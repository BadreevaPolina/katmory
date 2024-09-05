package com.example.katmory.data.source.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.example.katmory.data.source.local.entity.Quiz
import com.example.katmory.data.source.local.entity.Text
@Dao
interface TextQuizLevelDao {
    @Query("SELECT * FROM Text WHERE level = :level")
    suspend fun getTextByLevel(level: Int): Text

    @Query("SELECT * FROM Quiz WHERE level = :level")
    suspend fun getQuizzesByLevel(level: Int): List<Quiz>
}