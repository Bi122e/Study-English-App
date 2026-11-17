package com.example.studyenglishapp.data.repository

 import com.example.studyenglishapp.data.local.dao.WordDao
import com.example.studyenglishapp.data.local.entity.WordEntity
import kotlinx.coroutines.flow.Flow

class WordRepository(
    private val wordDao: WordDao

) {

    //lay het tu vung
    fun getAllWords(): Flow<List<WordEntity>> {
        return wordDao.getAllWords()
    }

    //  val allWords: Flow<List<WordEntity>> =
    //        wordDao.getAllWords()


    //tim kiem tu vung
    fun findWord(query: String): Flow<List<WordEntity>> {
        return wordDao.searchWords(query)
    }

    //them tu vung
    suspend fun addWord(word: WordEntity) {
        wordDao.updateWord(word)
    }

    //xoa tu vung
    suspend fun deleteWord(word: WordEntity) {
        wordDao.deleteWord(word)
    }

    suspend fun insertWord(word: WordEntity) {
        wordDao.insertWord(word)
    }

    suspend fun updateWord(word: WordEntity) {
        wordDao.updateWord(word)
    }
    //cap nhat yeu thich
    suspend fun updateFavorite(
        wordId: Int,
        isFavorite: Boolean
    ) {
        wordDao.updateFavorite(wordId, isFavorite)
    }


 }