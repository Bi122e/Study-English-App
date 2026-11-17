package com.example.studyenglishapp.ui.vocabulary

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.studyenglishapp.data.local.entity.WordEntity
import com.example.studyenglishapp.data.repository.WordRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class VocabularyViewModel(
    private val wordRepository: WordRepository
): ViewModel() {
    val words = wordRepository.getAllWords().stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = emptyList()
    )


    //them word
    fun insertWord(word: WordEntity) {
        viewModelScope.launch {
            wordRepository.insertWord(word)
        }
    }

    //xoa tu vung
    fun deleteWord(word: WordEntity) {
        viewModelScope.launch {
            wordRepository.deleteWord(word)
        }
    }

    //update
    fun updateWord(word: WordEntity) {
        viewModelScope.launch {
            wordRepository.updateWord(word)
        }
    }

    fun updateFavorite(wordId: Int, isFavorite: Boolean) {
        viewModelScope.launch {
            wordRepository.updateFavorite(wordId, isFavorite)
        }
    }
}