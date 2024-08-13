package com.heygongc.domain.interfaces

interface NavigableScreen {
    val route: String
    fun createRoute(arg: String): String = route
}