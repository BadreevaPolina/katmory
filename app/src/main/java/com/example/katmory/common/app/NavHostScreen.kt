package com.example.katmory.common.app

import androidx.compose.runtime.*
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.katmory.common.utils.GameType
import com.example.katmory.ui.viewmodel.GameViewModel
import com.example.katmory.ui.views.mainScreens.StartScreen
import com.example.katmory.ui.views.components.common.LoadingScreen
import com.example.katmory.ui.views.errorletScreens.ErrorletResultScreen
import com.example.katmory.ui.views.errorletScreens.ErrorletStartScreen
import com.example.katmory.ui.views.mainScreens.MenuScreen
import com.example.katmory.ui.views.texterScreens.QuestionTexterScreen
import com.example.katmory.ui.views.texterScreens.ResultTexterScreen
import com.example.katmory.ui.views.texterScreens.StartTexterScreen

const val ERRORLET = "errorlet"
const val TEXTER = "texter"
const val START = "/start"
const val NEXTLEVEL = "/nextLevel"
const val QUESTION = "/question"
const val RESULT = "/result"
const val ISCORRECT = "isCorrect"

@Composable
fun NavHostScreen(navController: NavHostController, gameViewModel: GameViewModel) {
    NavHost(navController = navController, startDestination = "start") {
        addMainRoutes(navController)
        addTexterRoutes(navController, gameViewModel)
        addErrorletRoutes(navController, gameViewModel)
    }
}

fun NavGraphBuilder.addMainRoutes(navController: NavHostController) {
    composable("start") { StartScreen(navController) }
    composable("typeGame") { MenuScreen(navController) }
}

fun NavGraphBuilder.addTexterRoutes(navController: NavHostController, gameViewModel: GameViewModel) {
    composable(TEXTER + START) {
        LaunchedEffect(Unit) { gameViewModel.createAndStartGame(GameType.TEXTQUIZ) }
        gameViewModel.infoLevel?.let {
            StartTexterScreen(navController, it)
        } ?: LoadingScreen()
    }


    composable(TEXTER + NEXTLEVEL) {
        LaunchedEffect(Unit) { gameViewModel.nextLevel() }
        gameViewModel.infoLevel?.let {
            StartTexterScreen(navController, it)
        } ?: LoadingScreen()
    }

    composable(TEXTER + QUESTION) {
        gameViewModel.infoLevel?.let {
            QuestionTexterScreen(navController = navController, infoLevel = it)
        } ?: LoadingScreen()
    }

    composable(TEXTER + RESULT) {
        gameViewModel.infoLevel?.let {
            ResultTexterScreen(navController, gameViewModel.correctAnswersCount, it.level)
        } ?: LoadingScreen()
    }
}

fun NavGraphBuilder.addErrorletRoutes(navController: NavHostController, gameViewModel: GameViewModel) {
    composable(ERRORLET + START) {
        LaunchedEffect(Unit) { gameViewModel.createAndStartGame(GameType.SENTENCEERROR) }
        gameViewModel.infoLevel?.let {
            ErrorletStartScreen(navController, it)
        } ?: LoadingScreen()
    }

    composable(ERRORLET + NEXTLEVEL) {
        LaunchedEffect(Unit) { gameViewModel.nextLevel() }
        gameViewModel.infoLevel?.let {
            ErrorletStartScreen(navController, it)
        } ?: LoadingScreen()
    }

    composable("$ERRORLET/{$ISCORRECT}") { backStackEntry ->
        val isCorrect = (backStackEntry.arguments?.getString(ISCORRECT)).toBoolean()
        gameViewModel.infoLevel?.rule?.let {
            ErrorletResultScreen(navController, isCorrect, it)
        } ?: LoadingScreen()
    }
}

