package com.heygongc.feature.login.navigation.destination

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.heygongc.feature.login.TestScreen
import com.heygongc.feature.login.navigation.Screen

fun NavGraphBuilder.testComposable() {
    composable(
        route = Screen.Test.route,
    ) {
        TestScreen()
    }
}