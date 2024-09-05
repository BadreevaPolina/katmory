package com.example.katmory.ui.views.components.texter

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.katmory.R
import com.example.katmory.ui.views.components.theme.fontFamily

@Composable
fun DisplayResultTexter(result: Int) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 350.dp, max = 350.dp)
            .background(Color.White)
            .border(2.dp, Color.Black, RoundedCornerShape(20.dp))
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Результат",
                fontSize = 26.sp,
                fontFamily = fontFamily,
                fontWeight = FontWeight.Normal,
                color = Color.Black,
                modifier = Modifier.padding(bottom = 8.dp)
            )

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "$result/5",
                    fontSize = 70.sp,
                    fontFamily = fontFamily,
                    fontWeight = FontWeight.Normal,
                    color = Color.Black
                )
            }

            Image(
                painter = painterResource(id = R.drawable.preview_ranby),
                contentDescription = "Рагби",
                modifier = Modifier
                    .size(width = 250.dp, height = 260.dp)
                    .padding(top = 16.dp)
            )
        }
    }
}