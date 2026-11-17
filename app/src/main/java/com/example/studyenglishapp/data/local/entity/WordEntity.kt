package com.example.studyenglishapp.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

//Định nghĩa cấu trúc bảng
@Entity(tableName = "words")
data class WordEntity (
    @PrimaryKey (autoGenerate = true)
    val id: Int = 0,
    val word: String,
    val meaning: String,
    val pronunciation: String,
    val example: String,
    val exampleMeaning: String,
    val partOfSpeech: String,
    val categoryId: Int,
    val isFavorite: Boolean = false,
    val isLearned: Boolean = false

)

