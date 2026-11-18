package com.example.studyenglishapp.ui.vocabulary

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.studyenglishapp.data.repository.WordRepository


//interface android cung cap de tu dinh nghia cach tao viewmodel
class VocabularyViewModelFactory(
    private val repository: WordRepository
): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {

        if (modelClass.isAssignableFrom(
                VocabularyViewModel::class.java
        )) {
            @Suppress("UNCHECKED_CAST")
            return VocabularyViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}