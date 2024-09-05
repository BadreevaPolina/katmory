package com.example.katmory.ui.views.components.texter

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.katmory.R
import com.example.katmory.ui.views.components.theme.fontFamily

@Composable
fun PagedContent(title: String, contentText: String) {
    val pageSize = 190
    val pages = remember { mutableStateListOf<String>() }
    LaunchedEffect(contentText) {
        pages.addAll(splitTextIntoPages(contentText, pageSize))
    }
    var currentPage by remember { mutableIntStateOf(0) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        DisplayTitle(title)
        Spacer(modifier = Modifier.height(10.dp))
        if (pages.isNotEmpty()) {
            DisplayTextTexter(text = pages[currentPage])
        }
        Spacer(modifier = Modifier.height(10.dp))
        PaginationControls(
            currentPage = currentPage,
            totalPages = pages.size,
            onPrevClick = { if (currentPage > 0) currentPage-- },
            onNextClick = { if (currentPage < pages.size - 1) currentPage++ }
        )
    }
}


fun splitTextIntoPages(text: String, pageSize: Int): List<String> {
    return text.split(" ")
        .fold(mutableListOf<String>() to StringBuilder()) { (pages, currentPageText), word ->
            if (currentPageText.length + word.length + 1 > pageSize) {
                pages.add(currentPageText.toString())
                pages to StringBuilder(word)
            } else {
                currentPageText.append(if (currentPageText.isNotEmpty()) " $word" else word)
                pages to currentPageText
            }
        }
        .let { (pages, currentPageText) ->
            if (currentPageText.isNotEmpty()) {
                pages.add(currentPageText.toString())
            }
            pages
        }
}

@Composable
fun PaginationControls(
    currentPage: Int,
    totalPages: Int,
    onPrevClick: () -> Unit,
    onNextClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Image(
            painter = painterResource(id = R.drawable.arrow),
            contentDescription = "Назад",
            modifier = Modifier
                .size(50.dp)
                .clickable(enabled = currentPage > 0) { onPrevClick() }
                .rotate(180f)
                .alpha(if (currentPage > 0) 1f else 0.5f)
        )
        Text(
            text = "${currentPage + 1} из $totalPages",
            fontSize = 20.sp,
            fontWeight = FontWeight.SemiBold,
            fontFamily = fontFamily,
            color = Color.Black,
            textAlign = TextAlign.Center
        )

        Image(
            painter = painterResource(id = R.drawable.arrow),
            contentDescription = "Вперед",
            modifier = Modifier
                .size(50.dp)
                .clickable(enabled = currentPage < totalPages - 1) { onNextClick() }
                .alpha(if (currentPage < totalPages - 1) 1f else 0.5f)
        )
    }
}