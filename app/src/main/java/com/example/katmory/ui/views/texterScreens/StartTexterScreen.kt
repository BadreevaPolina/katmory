package com.example.katmory.ui.views.texterScreens

import ContinueButton
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.katmory.common.app.QUESTION
import com.example.katmory.common.app.TEXTER
import com.example.katmory.data.source.local.response.InfoLevel
import com.example.katmory.ui.viewmodel.MusicViewModel
import com.example.katmory.ui.views.components.common.Header
import com.example.katmory.ui.views.components.common.ScreenBackground
import com.example.katmory.ui.views.components.texter.PagedContent

@Composable
fun StartTexterScreen(
    navController: NavHostController,
    infoLevel: InfoLevel,
    musicViewModel: MusicViewModel = hiltViewModel()
) {
    ScreenBackground { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Header(navController = navController, level = infoLevel.level, musicViewModel = musicViewModel)
            infoLevel.name?.let { PagedContent(it, infoLevel.text) }
            ContinueButton(onClick = { navController.navigate(TEXTER + QUESTION) })
        }
    }
}