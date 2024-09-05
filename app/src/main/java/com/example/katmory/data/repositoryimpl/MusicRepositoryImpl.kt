package com.example.katmory.data.repositoryimpl

import com.example.katmory.domain.repository.MusicRepository

import android.content.Context
import android.media.MediaPlayer
import javax.inject.Inject

class MusicRepositoryImpl @Inject constructor(private val context: Context) : MusicRepository {
    private var mediaPlayer: MediaPlayer? = null

    override fun playMusic(resourceId: Int) {
        stopMusic()
        mediaPlayer = MediaPlayer.create(context, resourceId)
        mediaPlayer?.start()
    }

    override fun stopMusic() {
        mediaPlayer?.apply {
            stop()
            release()
        }
        mediaPlayer = null
    }
}
