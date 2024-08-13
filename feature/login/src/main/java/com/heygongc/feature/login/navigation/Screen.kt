package com.heygongc.feature.login.navigation

import com.heygongc.domain.constant.LOGIN_SCREEN
import com.heygongc.domain.constant.TEST_SCREEN
import com.heygongc.domain.interfaces.NavigableScreen

sealed class Screen(
    override val route: String,
) : NavigableScreen {
    data object Login : Screen(LOGIN_SCREEN)
    data object Test : Screen(TEST_SCREEN)
}