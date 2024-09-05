package com.example.katmory.domain.usecase

import com.example.katmory.domain.repository.MusicRepository
import javax.inject.Inject

class MusicUseCase @Inject constructor(private val musicRepository: MusicRepository) {

    fun playBackgroundMusic(resourceId: Int) {
        musicRepository.playMusic(resourceId)
    }

    fun stopBackgroundMusic() {
        musicRepository.stopMusic()
    }
}
