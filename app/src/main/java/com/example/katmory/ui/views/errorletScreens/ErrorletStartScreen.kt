package com.example.katmory.ui.views.errorletScreens

import ContinueButton
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.katmory.common.app.ERRORLET
import com.example.katmory.data.source.local.response.InfoLevel
import com.example.katmory.ui.viewmodel.MusicViewModel
import com.example.katmory.ui.views.components.common.AnswerOptions
import com.example.katmory.ui.views.components.common.Header
import com.example.katmory.ui.views.components.common.ScreenBackground
import com.example.katmory.ui.views.components.errorlet.DisplayTextErrorlet


@Composable
fun ErrorletStartScreen(
    navController: NavHostController,
    infoLevel: InfoLevel,
    musicViewModel: MusicViewModel = hiltViewModel()
) {
    var selectedOption by remember { mutableStateOf<String?>(null) }

    infoLevel.let { levelInfo ->
        val answerOptions = levelInfo.question.firstOrNull()?.options ?: emptyList()
        val text = levelInfo.text
        val rightAnswer = levelInfo.question.firstOrNull()?.rightAnswer

        ScreenBackground { innerPadding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Header(navController = navController, level = levelInfo.level, musicViewModel = musicViewModel)
                DisplayTextErrorlet(text)
                AnswerOptions(answerOptions, onOptionSelected = { selectedOption = it })
                ContinueButton(
                    onClick = {
                        if (selectedOption != null) {
                            val isCorrect = (selectedOption == rightAnswer)
                            navController.navigate("$ERRORLET/$isCorrect")
                        }
                    }
                )

            }
        }
    }
}
