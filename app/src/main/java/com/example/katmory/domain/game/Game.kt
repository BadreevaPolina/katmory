package com.example.katmory.domain.game

import com.example.katmory.common.utils.GameType
import com.example.katmory.data.source.local.response.InfoLevel
import com.example.katmory.domain.repository.GameManager


abstract class Game {
    abstract val gameManager: GameManager
    abstract val gameType: GameType
    abstract val totalLevels: Int

    open suspend fun startGame(): InfoLevel {
        val level = gameManager.getCurrentLevel(gameType)
        return gameManager.getInfoLevel(gameType, level)
    }

    open suspend fun nextLevel(): InfoLevel {
        val level = gameManager.getCurrentLevel(gameType)
        val nextLevel = if (level + 1 > totalLevels) {
            totalLevels
        } else {
            level + 1
        }
        gameManager.setCurrentLevel(gameType, nextLevel)
        return gameManager.getInfoLevel(gameType, nextLevel)
    }
}