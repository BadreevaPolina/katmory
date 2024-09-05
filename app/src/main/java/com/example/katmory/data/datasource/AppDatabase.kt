package com.example.katmory.data.datasource

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.katmory.data.source.local.dao.SentenceErrorLevelDao
import com.example.katmory.data.source.local.dao.TextQuizLevelDao
import com.example.katmory.data.source.local.entity.Quiz
import com.example.katmory.data.source.local.entity.SentenceError
import com.example.katmory.data.source.local.entity.Text

@Database(entities = [SentenceError::class, Text::class, Quiz::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun textQuizLevelDao(): TextQuizLevelDao
    abstract fun sentenceErrorLevelDao(): SentenceErrorLevelDao
}