package com.example.common_ui.ui.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.runningFold
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

abstract class ViewModelBase<STATE, INTENT, EVENT>(
    initialState: STATE,
    sharingStarted: SharingStarted = SharingStarted.Lazily
) : ViewModel() {

    private val intentStateMachine = Channel<INTENT> { intent ->
        // handle UndeliveredElement here
    }

    val uiState = intentStateMachine
        .receiveAsFlow()
        .runningFold(initialState) { oldState: STATE, intent: INTENT ->
            oldState.reduce(intent)
        }
        .stateIn(viewModelScope, sharingStarted, initialState)

    private val eventChannel = Channel<EVENT>()
    val eventFlow = eventChannel.receiveAsFlow()

    /**
     * INTENT 를 channel 에 전달, 해당 channel 을 flow 로 받는 uiState 를 업데이트 하기 위한 함수
     */
    protected fun execute(intent: INTENT) {
        viewModelScope.launch {
            intentStateMachine.send(intent)
        }
    }

    protected suspend fun executeInScope(intent: INTENT) {
        intentStateMachine.send(intent)
    }

    /**
     * UI Event 를 channel 에 전달, 해당 channel 을 flow 로 받는 event 를 통해 수신
     */
    protected fun sendEvent(event: EVENT) {
        viewModelScope.launch {
            eventChannel.send(event)
        }
    }

    abstract suspend fun STATE.reduce(intent: INTENT): STATE
}