package com.example.katmory.data.repository

import com.example.katmory.common.utils.GameType
import com.example.katmory.data.source.local.response.InfoLevel

interface ILevelRepository {
    suspend fun getLevelInfo(gameType: GameType, level: Int): InfoLevel
}