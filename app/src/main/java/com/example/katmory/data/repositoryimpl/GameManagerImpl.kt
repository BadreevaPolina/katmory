package com.example.katmory.data.repositoryimpl

import com.example.katmory.common.utils.GameType
import com.example.katmory.data.repository.IGameStateRepository
import com.example.katmory.data.repository.ILevelRepository
import com.example.katmory.data.source.local.response.InfoLevel
import com.example.katmory.domain.repository.GameManager


class GameManagerImpl(
    private val levelRepository: ILevelRepository,
    private val gameStateRepository: IGameStateRepository
) : GameManager {
    override suspend fun getInfoLevel(gameType: GameType, level: Int): InfoLevel =
        levelRepository.getLevelInfo(gameType, level)


    override suspend fun getCurrentLevel(gameType: GameType): Int {
        return gameStateRepository.getCurrentLevel(gameType)
    }

    override suspend fun setCurrentLevel(gameType: GameType, level: Int) {
        gameStateRepository.setCurrentLevel(gameType, level)
    }
}