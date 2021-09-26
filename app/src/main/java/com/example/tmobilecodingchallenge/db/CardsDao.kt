package com.example.tmobilecodingchallenge.db

import androidx.room.*
import com.example.tmobilecodingchallenge.models.Cards
import kotlinx.coroutines.flow.Flow

@Dao
interface CardsDao {

    @Query("SELECT * FROM cards_table")
    fun getAllCards(): Flow<List<Cards>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCards(cards: List<Cards>)

    @Query("DELETE FROM cards_table")
    suspend fun deleteAllCards()
}