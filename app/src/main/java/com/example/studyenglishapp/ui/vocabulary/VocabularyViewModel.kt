package com.example.studyenglishapp.ui.vocabulary

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.studyenglishapp.data.local.entity.WordEntity
import com.example.studyenglishapp.data.repository.WordRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import kotlin.time.Duration.Companion.milliseconds

class VocabularyViewModel(
    private val wordRepository: WordRepository
): ViewModel() {


    private val _searchQuery = MutableStateFlow("")
    val searchQuery = _searchQuery.asStateFlow()

    val words = wordRepository.getAllWords().stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = emptyList()
    )


    //search
    @OptIn(ExperimentalCoroutinesApi::class, FlowPreview::class)
    val searchResults = searchQuery
        .debounce(300.milliseconds)
        .flatMapLatest { query ->
            if (query.isBlank()) {
                wordRepository.getAllWords()
            } else {
                wordRepository.findWord(query)
            }
        }
        .stateIn(
            scope =  viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = emptyList()
        )

    fun onSearchQueryChange(query: String) {
        _searchQuery.value = query
    }
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