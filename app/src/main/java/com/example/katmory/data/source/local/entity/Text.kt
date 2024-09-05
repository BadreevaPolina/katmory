package com.example.katmory.data.source.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

@Entity(tableName = "Text")
data class Text(
    @PrimaryKey
    @NotNull val level: Int,
    @NotNull val name: String,
    @NotNull val text: String
)
