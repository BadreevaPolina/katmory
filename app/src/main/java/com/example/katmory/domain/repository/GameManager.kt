package com.example.katmory.domain.repository

import com.example.katmory.common.utils.GameType
import com.example.katmory.data.source.local.response.InfoLevel

interface GameManager {
    suspend fun getInfoLevel(gameType: GameType, level: Int): InfoLevel
    suspend fun getCurrentLevel(gameType: GameType): Int
    suspend fun setCurrentLevel(gameType: GameType, level: Int)
}