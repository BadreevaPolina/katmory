package com.example.katmory.data.source.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.example.katmory.data.source.local.entity.SentenceError

@Dao
interface SentenceErrorLevelDao {
    @Query("SELECT * FROM SentenceError WHERE level = :level")
    suspend fun getLevel(level: Int): SentenceError
}