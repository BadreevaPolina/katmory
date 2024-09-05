package com.example.katmory.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.katmory.domain.usecase.MusicUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MusicViewModel @Inject constructor(
    private val musicUseCase: MusicUseCase
) : ViewModel() {

    private val _isMusicPlaying = MutableLiveData(false)
    val isMusicPlaying: LiveData<Boolean> get() = _isMusicPlaying

    fun playBackgroundMusic(resourceId: Int) {
        viewModelScope.launch {
            musicUseCase.playBackgroundMusic(resourceId)
            _isMusicPlaying.value = true
        }
    }

    fun stopBackgroundMusic() {
        viewModelScope.launch {
            musicUseCase.stopBackgroundMusic()
            _isMusicPlaying.value = false
        }
    }

    override fun onCleared() {
        super.onCleared()
        stopBackgroundMusic()
    }
}
