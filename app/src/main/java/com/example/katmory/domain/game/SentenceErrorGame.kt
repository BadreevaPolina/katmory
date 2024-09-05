package com.example.katmory.domain.game

import com.example.katmory.common.utils.GameType
import com.example.katmory.domain.repository.GameManager

class SentenceErrorGame(override val gameManager: GameManager) : Game() {
    override val gameType = GameType.SENTENCEERROR
    override val totalLevels = 42
}