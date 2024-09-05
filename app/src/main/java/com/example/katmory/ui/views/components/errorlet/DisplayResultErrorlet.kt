package com.example.katmory.ui.views.components.errorlet

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.katmory.R
import com.example.katmory.ui.views.components.theme.fontFamily

@Composable
fun DisplayResultErrorlet(isCorrect: Boolean){
    ResultText(isCorrect)
    ResultImage(isCorrect)
}

@Composable
private fun ResultText(isCorrect: Boolean) {
    Text(
        text = if (isCorrect) stringResource(id = R.string.win) else stringResource(id = R.string.lose),
        fontSize = 24.sp,
        fontFamily = fontFamily,
        fontWeight = FontWeight.Bold
    )
}

@Composable
private fun ResultImage(isCorrect: Boolean) {
    Image(
        painter = painterResource(
            id = if (isCorrect) R.drawable.correct_result else R.drawable.incorrect_result
        ),
        contentDescription = null,
        modifier = Modifier.size(100.dp)
    )
}