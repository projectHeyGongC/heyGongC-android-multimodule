package com.heygongc.feature.login

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.NavHostController
import com.heygongc.feature.login.mvi.LoginEvent
import com.heygongc.feature.login.navigation.Screen
import com.heygongc.feature.login.viewmodel.LoginViewModel

@Composable
fun LoginScreen() {
    val navController: NavHostController = LocalMainNavHost.current
    val viewModel: LoginViewModel = hiltViewModel()
    val lifecycleOwner = LocalLifecycleOwner.current
    val clickItem: (String) -> Unit = { destination -> viewModel.clickItem(destination) }
    LoginScreenContent(clickItem = clickItem)

    LaunchedEffect(Unit) {
        lifecycleOwner.lifecycle.repeatOnLifecycle(androidx.lifecycle.Lifecycle.State.STARTED) {
            viewModel.eventFlow.collect { eventUi ->
                when (eventUi) {
                    is LoginEvent.OnClickItem -> {
                        viewModel.sendNavigate(eventUi.destination)
                    }

                    is LoginEvent.OnNavigate -> {
                        navController.navigate(eventUi.destination!!)
                    }
                }
            }
        }
    }
}

@Composable
private fun LoginScreenContent(clickItem: (String) -> Unit) {
    Scaffold(
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .padding(paddingValues)
                    .fillMaxSize(),
                verticalArrangement = androidx.compose.foundation.layout.Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Button(onClick = { clickItem.invoke(Screen.Test.route) }, content = {
                    Text("다음 화면으로 이동")
                })
            }
        }
    )
}

@Preview
@Composable
private fun LoginScreenPreview() {
    LoginScreenContent { }
}