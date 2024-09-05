package com.example.katmory.ui.views.components.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.katmory.R
import com.example.katmory.ui.viewmodel.MusicViewModel
import com.example.katmory.ui.views.components.theme.fontFamily

private val ButtonHeight = 50.dp
private val ButtonCornerRadius = 20.dp
private val ButtonTextFontSize = 26.sp
private val ButtonTextPadding = PaddingValues(horizontal = 20.dp)

@Composable
fun Header(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    level: Int,
    musicViewModel: MusicViewModel
) {
    val isMusicPlaying by musicViewModel.isMusicPlaying.observeAsState(false)
    val iconResource = if (isMusicPlaying) R.drawable.sound_on else R.drawable.sound_off

    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 15.dp, vertical = 5.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            MenuButton(
                onClick = {
                    navController.navigate("typeGame")
                    if (isMusicPlaying) {
                        musicViewModel.stopBackgroundMusic()
                    }
                }
            )
            LevelButton(level = level)
            SoundButton(
                iconResource = iconResource,
                onClick = {
                    if (isMusicPlaying) {
                        musicViewModel.stopBackgroundMusic()
                    } else {
                        musicViewModel.playBackgroundMusic(R.raw.music)
                    }
                }
            )
        }
    }
}

@Composable
fun LevelButton(modifier: Modifier = Modifier, level: Int) {
    Box(
        modifier = modifier
            .height(ButtonHeight)
            .wrapContentWidth(),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.level),
            contentDescription = "Level Icon",
            contentScale = ContentScale.Crop,
            modifier = Modifier.height(ButtonHeight),
        )
        Text(
            text = level.toString(),
            fontSize = 24.sp,
            fontFamily = fontFamily,
            fontWeight = FontWeight.W400,
            color = Color.Black
        )
    }
}

@Composable
fun SoundButton(
    modifier: Modifier = Modifier,
    iconResource: Int,
    onClick: () -> Unit
) {
    Image(
        painter = painterResource(id = iconResource),
        contentDescription = "Sound Icon",
        contentScale = ContentScale.Crop,
        modifier = modifier
            .height(ButtonHeight)
            .clickable(onClick = onClick)
    )
}

@Composable
fun MenuButton(modifier: Modifier = Modifier, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = modifier
            .height(ButtonHeight)
            .wrapContentWidth()
            .border(2.dp, Color.Black, RoundedCornerShape(ButtonCornerRadius)),
        shape = RoundedCornerShape(ButtonCornerRadius),
        contentPadding = PaddingValues(0.dp),
        colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.main_pink))
    ) {
        Text(
            text = "Меню",
            fontSize = ButtonTextFontSize,
            fontFamily = fontFamily,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            modifier = Modifier.padding(ButtonTextPadding)
        )
    }
}
