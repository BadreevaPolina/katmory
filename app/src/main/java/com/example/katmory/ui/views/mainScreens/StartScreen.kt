package com.example.katmory.ui.views.mainScreens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.katmory.R

@Composable
fun StartScreen(navController: NavController) {
    Column(
        Modifier
            .fillMaxSize()
            .background(color = Color(0xFF003D5B))
            .padding(16.dp),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(Modifier.weight(1f))
        Column(
            Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(R.drawable.preview_katmory),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth(fraction = 0.75f)
                    .aspectRatio(2.6f)
                    .padding(bottom = 10.dp)
            )
            Image(
                painter = painterResource(R.drawable.preview_ranby),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth(fraction = 0.7f)
                    .aspectRatio(1f)
                    .padding(bottom = 10.dp)
            )
            Image(
                painter = painterResource(R.drawable.preview_play),
                contentDescription = null,
                modifier = Modifier
                    .size(150.dp)
                    .clickable {
                        navController.navigate("typeGame") }
            )
        }
        Spacer(Modifier.weight(1f))
    }
}