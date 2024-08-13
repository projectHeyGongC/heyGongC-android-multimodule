package com.heygongc.feature.login.navigation.destination

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.heygongc.feature.login.LoginScreen
import com.heygongc.feature.login.navigation.Screen

fun NavGraphBuilder.loginComposable() {
    composable(
        route = Screen.Login.route,
    ) {
        LoginScreen()
    }
}