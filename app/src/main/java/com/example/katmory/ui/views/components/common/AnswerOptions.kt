package com.example.katmory.ui.views.components.common

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.FontWeight
import com.example.katmory.ui.views.components.theme.fontFamily


private val DefaultItemPadding = 10.dp

@Composable
fun AnswerOptions(optionList: List<String>, onOptionSelected: (String) -> Unit) {
    var selectedOption by remember { mutableStateOf<String?>(null) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = DefaultItemPadding),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        optionList.forEach { optionText ->
            AnswerOption(
                optionText = optionText,
                isSelected = (selectedOption == optionText),
                onClick = {
                    selectedOption = optionText
                    onOptionSelected(optionText)
                },
                itemPadding = DefaultItemPadding
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
    }
}

@Composable
fun AnswerOption(
    optionText: String,
    isSelected: Boolean,
    onClick: () -> Unit,
    itemPadding: Dp
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(itemPadding)
            .clickable(onClick = onClick)
            .background(Color.White, RoundedCornerShape(15.dp))
            .then(
                if (isSelected) {
                    Modifier.drawSolidBorder()
                } else {
                    Modifier.drawDashedBorder()
                }
            ),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = optionText,
            fontSize = 22.sp,
            fontFamily = fontFamily,
            fontWeight = FontWeight.Normal,
            color = Color.Black,
            modifier = Modifier.padding(8.dp)
        )
    }
}

@Composable
fun Modifier.drawDashedBorder(): Modifier = this.then(
    drawBehind {
        val pathEffect = PathEffect.dashPathEffect(floatArrayOf(10f, 10f), 0f)
        drawRoundRect(
            color = Color.Black,
            size = size,
            style = Stroke(
                width = 2.dp.toPx(),
                pathEffect = pathEffect
            ),
            cornerRadius = CornerRadius(15.dp.toPx())
        )
    }
)

@Composable
fun Modifier.drawSolidBorder(): Modifier = this.then(
    drawBehind {
        drawRoundRect(
            color = Color.Black,
            size = size,
            style = Stroke(
                width = 2.dp.toPx()
            ),
            cornerRadius = CornerRadius(15.dp.toPx())
        )
    }
)
