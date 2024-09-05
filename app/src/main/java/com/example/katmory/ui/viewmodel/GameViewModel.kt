package com.example.katmory.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import androidx.compose.runtime.*
import com.example.katmory.common.utils.GameState
import com.example.katmory.common.utils.GameType
import com.example.katmory.data.source.local.response.InfoLevel
import com.example.katmory.domain.usecase.GameUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class GameViewModel @Inject constructor(
    private val gameUseCase: GameUseCase
) : ViewModel() {

    private val _gameState = MutableStateFlow(GameState())
    val gameState: StateFlow<GameState> = _gameState.asStateFlow()
    val infoLevel: InfoLevel? get() = gameState.value.currentLevelInfo

    var correctAnswersCount by mutableIntStateOf(0)
    var currentQuestionIndex by mutableIntStateOf(0)

    fun createAndStartGame(gameType: GameType) {
        viewModelScope.launch {
            _gameState.value = GameState(isLoading = true)
            try {
                gameUseCase.createGame(gameType)
                _gameState.value = GameState(
                    currentLevelInfo = gameUseCase.startGame(),
                    currentGameType = gameType
                )
            } catch (e: Exception) {
                _gameState.value = GameState(error = e.message)
            }
        }
    }

    fun nextLevel() {
        viewModelScope.launch {
            resetCorrectAnswers()
            _gameState.value = _gameState.value.copy(isLoading = true)
            try {
                val nextLevelInfo = gameUseCase.nextLevel()
                _gameState.value = _gameState.value.copy(
                    currentLevelInfo = nextLevelInfo,
                    isLoading = false
                )
            } catch (e: Exception) {
                _gameState.value = GameState(error = e.message)
            }
        }
    }

    private fun resetCorrectAnswers() {
        correctAnswersCount = 0
    }

    fun getCurrentGameType(): GameType? {
        return gameState.value.currentGameType
    }
}