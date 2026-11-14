package com.example.studyenglishapp.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.PrimaryKey
import androidx.room.Query
import androidx.room.Update
import com.example.studyenglishapp.data.local.entity.WordEntity
import kotlinx.coroutines.flow.Flow

//Chứa các câu lệnh thao tác database


@Dao
interface WordDao {

    @Query("SELECT * FROM words ORDER BY word ASC")
    fun getAllWords(): Flow<List<WordEntity>>

    //LAY tu vung theo id
    @Query("SELECT * FROM words WHERE id = :wordId")
    suspend fun getWordById(wordId: Int): WordEntity?

    //tim tu vung
    @Query(
        """
            SELECT * FROM words
            WHERE word LIKE '%' || :query || '%'
            ORDER BY word ASC
        """
    )
    fun searchWords(query: String): Flow<List<WordEntity>>

    //lay ds yeu thich
    @Query("SELECT * FROM words WHERE isFavorite = 1")
    fun getFavoriteWords(): Flow<List<WordEntity>>

    //them tu vung
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertWords(words: List<WordEntity>)

    //cap nhat tu vung
    @Update
    suspend fun updateWord(word: WordEntity)

    //xoa
    @Delete
    suspend fun deleteWord(word: WordEntity
    )

    //cap nhat trang thai yeu thich
    @Query("""
        UPDATE words
        SET isFavorite = :isFavorite
        WHERE id = :wordId
    """)
    suspend fun updateFavorite(
        wordId: Int,
        isFavorite: Boolean
    )

    //danh dau da hoc
    @Query("""
        UPDATE words
        SET isLearned = :isLearned
        WHERE id = :wordId
    """)
    suspend fun updateLearned(
        wordId: Int,
        isLearned: Boolean
    )
}