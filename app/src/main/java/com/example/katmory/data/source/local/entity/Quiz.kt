package com.example.katmory.data.source.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull


@Entity(
    tableName = "Quiz",
    foreignKeys = [ForeignKey(
        entity = Text::class,
        parentColumns = ["level"],
        childColumns = ["level"],
        onDelete = ForeignKey.NO_ACTION
    )]
)
data class Quiz(
    @PrimaryKey
    @NotNull val id: Int,
    @NotNull val level: Int,
    @NotNull val question: String,
    @NotNull val options: String,
    @ColumnInfo(name = "right_answer")
    @NotNull val rightAnswer: String
)
