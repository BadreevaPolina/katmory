package com.example.katmory.ui.views

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.example.katmory.common.app.NavHostScreen
import com.example.katmory.ui.viewmodel.GameViewModel
import com.example.katmory.ui.views.errorletScreens.ErrorletResultScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            val gameViewModel = rememberGameViewModel()
            NavHostScreen(navController = navController, gameViewModel = gameViewModel)
        }
    }
}

@Composable
fun rememberGameViewModel(): GameViewModel {
    return viewModel()
}
