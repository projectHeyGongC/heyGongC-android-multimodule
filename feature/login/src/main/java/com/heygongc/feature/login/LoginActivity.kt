package com.heygongc.feature.login

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.heygongc.feature.login.navigation.SetUpNavigation
import dagger.hilt.android.AndroidEntryPoint

val LocalMainNavHost = staticCompositionLocalOf<NavHostController> { error("Nav host controller is not provided") }

@AndroidEntryPoint
class LoginActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            CompositionLocalProvider(LocalMainNavHost provides navController) {
                SetUpNavigation()
            }
        }
    }
}