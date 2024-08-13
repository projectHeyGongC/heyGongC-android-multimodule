package com.example.common_ui.ui.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun BaseScaffold(
    content: @Composable () -> Unit,
    modifier: Modifier = Modifier
) {
    Scaffold(
        content = { paddingValues ->
            Column(modifier = modifier.padding(paddingValues)) {
                content()
            }
        }
    )
}