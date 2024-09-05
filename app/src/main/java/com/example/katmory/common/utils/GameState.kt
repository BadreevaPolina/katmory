package com.example.katmory.common.utils

import com.example.katmory.data.source.local.response.InfoLevel

data class GameState(
    val currentGameType: GameType? = null,
    val currentLevelInfo: InfoLevel? = null,
    val isLoading: Boolean = false,
    val error: String? = null
)