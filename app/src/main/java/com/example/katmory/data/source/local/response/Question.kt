package com.example.katmory.data.source.local.response

data class Question(
    val question: String? = null,
    val options: List<String>,
    val rightAnswer: String
)