package com.example.katmory.di

import com.example.katmory.domain.usecase.GameUseCase
import com.example.katmory.domain.usecase.MusicUseCase
import com.example.katmory.ui.viewmodel.GameViewModel
import com.example.katmory.ui.viewmodel.MusicViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
class ViewModelModule {
    @Provides
    fun provideGameViewModel(gameUseCase: GameUseCase): GameViewModel {
        return GameViewModel(gameUseCase)
    }

    @Provides
    fun provideMusicViewModel(musicUseCase: MusicUseCase): MusicViewModel {
        return MusicViewModel(musicUseCase)
    }
}