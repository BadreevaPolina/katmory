package com.example.katmory.ui.views.components.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.example.katmory.R
import com.example.katmory.ui.views.components.theme.innerPadding

@Composable
fun ScreenBackground(content: @Composable (innerPadding: PaddingValues) -> Unit) {
    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.main_background),
            contentDescription = stringResource(id = R.string.main_background),
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        content(innerPadding)
    }
}