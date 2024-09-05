package com.example.katmory.ui.views.errorletScreens

import SmallContinueButton
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.katmory.common.app.ERRORLET
import com.example.katmory.common.app.NEXTLEVEL
import com.example.katmory.ui.views.components.errorlet.DisplayResultErrorlet
import com.example.katmory.ui.views.components.theme.fontFamily


@Composable
fun ErrorletResultScreen(navController: NavHostController, isCorrect: Boolean, rule: String) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black.copy(alpha = 0.4f))
            .clickable(enabled = false) {}  ) {
        Box(
            modifier = Modifier
                .size(300.dp, 510.dp)
                .background(Color.White, shape = RoundedCornerShape(20.dp))
                .align(Alignment.Center)
                .padding(16.dp)
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                DisplayResultErrorlet(isCorrect)
                Text(
                    text = rule,
                    textAlign = TextAlign.Center,
                    fontSize = 22.sp,
                    fontFamily = fontFamily,
                    color = Color.Gray,
                    modifier = Modifier.padding(vertical = 16.dp)
                )
                SmallContinueButton {
                    navController.navigate(ERRORLET + NEXTLEVEL)
                }
            }
        }
    }
}