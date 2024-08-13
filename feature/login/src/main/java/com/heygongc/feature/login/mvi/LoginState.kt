package com.heygongc.feature.login.mvi

import androidx.compose.runtime.Immutable

@Immutable
data class LoginState(
    val isLoading: Boolean = false
)