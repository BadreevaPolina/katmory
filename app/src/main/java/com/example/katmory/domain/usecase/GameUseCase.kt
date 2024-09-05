package com.example.katmory.domain.usecase

import com.example.katmory.common.utils.GameType
import com.example.katmory.data.source.local.response.InfoLevel
import com.example.katmory.domain.game.SentenceErrorGame
import com.example.katmory.domain.game.TextQuizGame
import com.example.katmory.domain.repository.GameManager
import com.example.katmory.domain.game.Game
import javax.inject.Inject

class GameUseCase @Inject constructor(private val gameManager: GameManager) {

    var game: Game? = null

    fun createGame(gameType: GameType) {
        game = when (gameType) {
            GameType.TEXTQUIZ -> TextQuizGame(gameManager)
            GameType.SENTENCEERROR -> SentenceErrorGame(gameManager)
        }
    }

    suspend fun startGame(): InfoLevel? {
        return game?.startGame()
    }

    suspend fun nextLevel(): InfoLevel? {
        return game?.nextLevel()
    }
}
