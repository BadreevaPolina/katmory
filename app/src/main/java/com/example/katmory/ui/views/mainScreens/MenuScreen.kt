package com.example.katmory.ui.views.mainScreens

import TypeGameButton
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.katmory.R
import com.example.katmory.common.utils.GameType
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.katmory.common.app.ERRORLET
import com.example.katmory.common.app.START
import com.example.katmory.common.app.TEXTER
import com.example.katmory.ui.viewmodel.GameViewModel
import com.example.katmory.ui.views.components.theme.fontFamily

@Composable
fun MenuScreen(
    navController: NavController,
    viewModel: GameViewModel = hiltViewModel()
) {
    val gameState by viewModel.gameState.collectAsState()

    LaunchedEffect(gameState.currentLevelInfo) {
        gameState.currentLevelInfo?.let {
            when (viewModel.getCurrentGameType()) {
                GameType.TEXTQUIZ -> { navController.navigate(TEXTER + START) }
                GameType.SENTENCEERROR -> { navController.navigate(ERRORLET + START) }
                else -> {}
            }
        }
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.menu_blue))
            .padding(top = 80.dp)
    ) {
        MenuButtons(viewModel = viewModel)
        Spacer(modifier = Modifier.height(60.dp))
        Spacer(modifier = Modifier.height(50.dp))
        MenuImage()

        when {
            gameState.isLoading -> {
                CircularProgressIndicator(
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )
            }
            gameState.error != null -> {
                Text(
                    text = gameState.error ?: "",
                    color = Color.Red,
                    fontFamily = fontFamily,
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )
            }
        }
    }
}

@Composable
fun MenuButtons(viewModel: GameViewModel) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly,
    ) {
        TypeGameButton(
            icon = R.drawable.icon_texter,
            text = stringResource(id = R.string.texter),
            onClick = {
                viewModel.createAndStartGame(GameType.TEXTQUIZ)
            }
        )
        TypeGameButton(
            icon = R.drawable.icon_error,
            text = stringResource(id = R.string.errorlet),
            onClick = {
                viewModel.createAndStartGame(GameType.SENTENCEERROR)
            }
        )
    }
}

@Composable
fun MenuImage() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        Image(
            painter = painterResource(id = R.drawable.ranby_head),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth(fraction = 0.85f)
                .aspectRatio(1.5f)
                .align(Alignment.BottomCenter)
        )
    }
}
