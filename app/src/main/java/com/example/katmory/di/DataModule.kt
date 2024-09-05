package com.example.katmory.di

import com.example.katmory.data.datasource.DatabaseHelper
import com.example.katmory.data.datasource.SharedPreferenceManager
import com.example.katmory.data.repository.IGameStateRepository
import com.example.katmory.data.repository.ILevelRepository
import com.example.katmory.data.repositoryimpl.GameManagerImpl
import com.example.katmory.data.repositoryimpl.GameStateRepositoryImpl
import com.example.katmory.data.repositoryimpl.LevelRepositoryImpl
import com.example.katmory.domain.repository.GameManager
import com.example.katmory.domain.repository.MusicRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
class DataModule {
    @Provides
    fun provideLevelRepository(databaseHelper: DatabaseHelper): ILevelRepository {
        return LevelRepositoryImpl(databaseHelper)
    }

    @Provides
    fun provideGameStateRepository(sharedPreferenceManager: SharedPreferenceManager): IGameStateRepository {
        return GameStateRepositoryImpl(sharedPreferenceManager)
    }
}