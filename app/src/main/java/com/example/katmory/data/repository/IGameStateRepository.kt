package com.example.katmory.data.repository

import com.example.katmory.common.utils.GameType

interface IGameStateRepository {
    suspend fun getCurrentLevel(gameType: GameType): Int
    suspend fun setCurrentLevel(gameType: GameType, level: Int)
}