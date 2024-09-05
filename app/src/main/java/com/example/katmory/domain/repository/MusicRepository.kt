package com.example.katmory.domain.repository

interface MusicRepository {
    fun playMusic(resourceId: Int)
    fun stopMusic()
}