package com.example.studyenglishapp.data.local.entity

import androidx.room.PrimaryKey

//Định nghĩa cấu trúc bảng
data class WordEntity (
    @PrimaryKey (autoGenerate = true)
    val id: Int = 0,
    val word: String,
    val meaning: String,
    val pronunciation: String,
    val example: String,
    val exampleMeaning: String,
    val partOfSpeed: String,
    val categoryId: Int,
    val isFavorite: Boolean = false,
    val isLearned: Boolean = false

)

