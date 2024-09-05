package com.example.katmory.domain.game

import com.example.katmory.common.utils.GameType
import com.example.katmory.domain.repository.GameManager

internal class TextQuizGame(override val gameManager: GameManager) :
    Game() {
    override val gameType = GameType.TEXTQUIZ
    override val totalLevels = 20
}