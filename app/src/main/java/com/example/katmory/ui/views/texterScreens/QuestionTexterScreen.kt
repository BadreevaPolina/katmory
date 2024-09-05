package com.example.katmory.ui.views.texterScreens

import ContinueButton
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.katmory.common.app.RESULT
import com.example.katmory.common.app.TEXTER
import com.example.katmory.data.source.local.response.InfoLevel
import com.example.katmory.data.source.local.response.Question
import com.example.katmory.ui.viewmodel.GameViewModel
import com.example.katmory.ui.viewmodel.MusicViewModel
import com.example.katmory.ui.views.components.common.AnswerOptions
import com.example.katmory.ui.views.components.common.Header
import com.example.katmory.ui.views.components.common.ScreenBackground
import com.example.katmory.ui.views.components.texter.DisplayQuestion

@Composable
fun QuestionTexterScreen(
    navController: NavHostController,
    infoLevel: InfoLevel?,
    musicViewModel: MusicViewModel = hiltViewModel(),
    gameViewModel: GameViewModel = hiltViewModel()
) {
    val currentQuestionIndex = gameViewModel.currentQuestionIndex

    infoLevel?.let { levelInfo ->
        val question = levelInfo.question[gameViewModel.currentQuestionIndex]
        var selectedOption by remember { mutableStateOf<String?>(null) }

        QuestionScreenContent(
            navController = navController,
            musicViewModel = musicViewModel,
            level = levelInfo.level,
            question = question,
            selectedOption = selectedOption,
            onOptionSelected = { selectedOption = it },
            onContinueClick = { isCorrect ->
                handleContinueClick(
                    isCorrect = isCorrect,
                    gameViewModel = gameViewModel,
                    currentQuestionIndex = currentQuestionIndex,
                    levelInfo = levelInfo,
                    navController = navController
                )
            }
        )
    }
}

@Composable
private fun QuestionScreenContent(
    navController: NavHostController,
    musicViewModel: MusicViewModel,
    level: Int,
    question: Question,
    selectedOption: String?,
    onOptionSelected: (String?) -> Unit,
    onContinueClick: (Boolean) -> Unit
) {
    ScreenBackground { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Header(navController = navController, level = level, musicViewModel = musicViewModel)
            question.question?.let { DisplayQuestion(it) }
            AnswerOptions(question.options, onOptionSelected = onOptionSelected)
            ContinueButton(
                onClick = { onContinueClick(selectedOption == question.rightAnswer) }
            )
        }
    }
}

private fun handleContinueClick(
    isCorrect: Boolean,
    gameViewModel: GameViewModel,
    currentQuestionIndex: Int,
    levelInfo: InfoLevel,
    navController: NavHostController
) {
    if (isCorrect) {
        gameViewModel.correctAnswersCount ++
    }
    if (currentQuestionIndex < (levelInfo.question.size - 2))
        gameViewModel.currentQuestionIndex ++
    else {
        gameViewModel.currentQuestionIndex = 0
        navController.navigate("$TEXTER$RESULT")
    }
}