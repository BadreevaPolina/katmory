package com.example.katmory.data.repositoryimpl

import com.example.katmory.common.utils.GameType
import com.example.katmory.data.datasource.SharedPreferenceManager
import com.example.katmory.data.repository.IGameStateRepository

class GameStateRepositoryImpl(private val sharedPreferenceManager: SharedPreferenceManager): IGameStateRepository {
    override suspend fun getCurrentLevel(gameType: GameType): Int {
        return sharedPreferenceManager.getCurrentLevel(gameType)
    }

    override suspend fun setCurrentLevel(gameType: GameType, level: Int) {
        sharedPreferenceManager.setCurrentLevel(gameType, level + 1)
    }
}
