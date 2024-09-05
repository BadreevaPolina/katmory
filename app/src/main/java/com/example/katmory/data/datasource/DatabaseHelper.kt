package com.example.katmory.data.datasource

import android.util.Log
import com.example.katmory.common.utils.GameType
import com.example.katmory.data.source.local.response.InfoLevel
import com.example.katmory.data.source.local.response.Question
import javax.inject.Inject

class DatabaseHelper @Inject constructor(
    private val database: AppDatabase
) {

    suspend fun getLevelInfo(gameType: GameType, level: Int): InfoLevel {
        return when (gameType) {
            GameType.SENTENCEERROR -> getSentenceErrorByLevel(level)
            GameType.TEXTQUIZ -> getTextQuizByLevel(level)
        }
    }

    private suspend fun getSentenceErrorByLevel(level: Int): InfoLevel {
        Log.i("DatabaseHelper","level for sentenceErrorLevelDao is $level")
        val gameDb = database.sentenceErrorLevelDao()

        val sentenceErrorLevel = gameDb.getLevel(level)
        val options = sentenceErrorLevel.options
        val question = listOf(
            Question(
                options = options.split(", "),
                rightAnswer = sentenceErrorLevel.rightAnswer
            )
        )
        return InfoLevel(
            level = sentenceErrorLevel.level,
            text = sentenceErrorLevel.text,
            question = question,
            rule = sentenceErrorLevel.rule
        )
    }

    private suspend fun getTextQuizByLevel(level: Int): InfoLevel {
        Log.i("DatabaseHelper","level for textQuizLevelDao is $level")
        val gameDb = database.textQuizLevelDao()
        val text = gameDb.getTextByLevel(level)
        val quizzes = gameDb.getQuizzesByLevel(level)

        val questions = quizzes.map {
            Question(
                question = it.question,
                options = it.options.split(", ").map { option -> option.trim() },
                rightAnswer = it.rightAnswer
            )
        }
        return InfoLevel(
            name = text.name,
            level = text.level,
            text = text.text,
            question = questions
        )
    }
}



