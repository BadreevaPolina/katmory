package com.example.katmory.di

import android.app.Application
import android.content.Context
import com.example.katmory.data.datasource.SharedPreferenceManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object AppModule {
    @Singleton
    @Provides
    fun provideContext(application: Application): Context = application.applicationContext

    @Provides
    fun provideSharedPreferenceManager(@ApplicationContext context: Context): SharedPreferenceManager {
        return SharedPreferenceManager(context)
    }
}