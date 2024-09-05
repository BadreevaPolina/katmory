package com.example.katmory.di

import com.example.katmory.domain.repository.GameManager
import com.example.katmory.domain.repository.MusicRepository
import com.example.katmory.domain.usecase.GameUseCase
import com.example.katmory.domain.usecase.MusicUseCase
import com.example.katmory.ui.viewmodel.GameViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {
    @Singleton
    @Provides
    fun provideGameUseCase(gameManager: GameManager): GameUseCase {
        return GameUseCase(gameManager)
    }

    @Singleton
    @Provides
    fun provideMusicUseCase(musicRepository: MusicRepository): MusicUseCase {
        return MusicUseCase(musicRepository)
    }
}
