package com.heygongc.feature.login.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.heygongc.domain.constant.LOGIN_SCREEN
import com.heygongc.feature.login.LocalMainNavHost
import com.heygongc.feature.login.navigation.destination.loginComposable
import com.heygongc.feature.login.navigation.destination.testComposable

@Composable
fun SetUpNavigation(
    navController: NavHostController = LocalMainNavHost.current,
) {
    NavHost(
        navController = navController,
        startDestination = LOGIN_SCREEN
    ) {
        loginComposable()
        testComposable()
    }
}