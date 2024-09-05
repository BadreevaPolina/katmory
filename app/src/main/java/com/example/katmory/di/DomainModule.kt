package com.example.katmory.di

import android.content.Context
import com.example.katmory.data.repository.IGameStateRepository
import com.example.katmory.data.repository.ILevelRepository
import com.example.katmory.data.repositoryimpl.GameManagerImpl
import com.example.katmory.domain.repository.GameManager
import com.example.katmory.domain.repository.MusicRepository
import com.example.katmory.data.repositoryimpl.MusicRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class DomainModule {
    @Provides
    fun provideGameManager(levelRepository: ILevelRepository, gameStateRepository: IGameStateRepository): GameManager {
        return GameManagerImpl(levelRepository, gameStateRepository)
    }

    @Provides
    @Singleton
    fun provideMusicRepository(@ApplicationContext context: Context): MusicRepository {
        return MusicRepositoryImpl(context)
    }

}