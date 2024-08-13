package com.heygongc.feature.login.viewmodel

import com.example.common_ui.ui.base.ViewModelBase
import com.heygongc.feature.login.mvi.LoginEvent
import com.heygongc.feature.login.mvi.LoginIntent
import com.heygongc.feature.login.mvi.LoginState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor() : ViewModelBase<LoginState, LoginIntent, LoginEvent>(LoginState()) {
    fun clickItem(destination: String) {
        sendEvent(LoginEvent.OnClickItem(destination))
    }

    fun sendNavigate(destination: String?) {
        sendEvent(LoginEvent.OnNavigate(destination))
    }

    override suspend fun LoginState.reduce(intent: LoginIntent): LoginState {
        TODO("Not yet implemented")
    }
}