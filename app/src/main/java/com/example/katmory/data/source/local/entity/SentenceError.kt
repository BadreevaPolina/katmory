package com.example.katmory.data.source.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

@Entity(tableName = "SentenceError")
data class SentenceError(
    @PrimaryKey(autoGenerate = true)
    @NotNull val id: Int,
    @NotNull val level: Int,
    @NotNull val text: String,
    @NotNull val options: String,
    @ColumnInfo(name = "right_answer") val rightAnswer: String,
    @NotNull val rule: String
)

