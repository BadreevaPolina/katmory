package com.example.katmory.data.source.local.response

data class InfoLevel (
    val level: Int,
    val name: String? = null,
    val text: String,
    val question: List<Question>,
    val rule: String? = null,
)