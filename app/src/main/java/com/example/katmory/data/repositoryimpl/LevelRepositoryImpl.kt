package com.example.katmory.data.repositoryimpl

import com.example.katmory.common.utils.GameType
import com.example.katmory.data.datasource.DatabaseHelper
import com.example.katmory.data.repository.ILevelRepository
import com.example.katmory.data.source.local.response.InfoLevel

class LevelRepositoryImpl(private val databaseHelper: DatabaseHelper): ILevelRepository {
    override suspend fun getLevelInfo(gameType: GameType, level: Int): InfoLevel =
        databaseHelper.getLevelInfo(gameType, level)
}