package com.example.katmory.ui.views.components.texter

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.katmory.ui.views.components.theme.fontFamily


@Composable
fun DisplayTextTexter(text: String) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 350.dp, max = 350.dp)
            .background(Color.White)
            .border(2.dp, Color.Black, RoundedCornerShape(20.dp))
            .padding(16.dp)
    ) {
        Text(
            text = text,
            fontSize = 26.sp,
            fontFamily = fontFamily,
            fontWeight = FontWeight.Normal,
            color = Color.Black
        )
    }
}