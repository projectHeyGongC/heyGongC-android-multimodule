package com.heygongc.feature.login.mvi

sealed interface LoginEvent {
    data class OnNavigate(val destination : String?) : LoginEvent
    data class OnClickItem(val destination: String?) : LoginEvent
}