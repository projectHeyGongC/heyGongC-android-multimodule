package com.heygongc.feature.login

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun TestScreen() {
    TestScreenContent()
}

@Composable
private fun TestScreenContent() {

    Scaffold(content = { paddingValues ->
        Column(modifier = Modifier.padding(paddingValues)) {
            Text("Test 스크린 입니다")
        }
    })
}

@Preview
@Composable
private fun TestScreenPreview() {
    TestScreenContent()
}