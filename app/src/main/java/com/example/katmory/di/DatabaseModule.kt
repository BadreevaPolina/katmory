package com.example.katmory.di

import android.content.Context
import androidx.room.Room
import com.example.katmory.data.datasource.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DatabaseModule {
    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context) =
        Room.databaseBuilder(context, AppDatabase::class.java, "game-levels")
            .createFromAsset("game-levels.db")
            .build()

    @Singleton
    @Provides
    fun provideTextQuizLevelDao(database: AppDatabase) = database.textQuizLevelDao()

    @Singleton
    @Provides
    fun provideSentenceErrorLevelDao(database: AppDatabase) = database.sentenceErrorLevelDao()
}

