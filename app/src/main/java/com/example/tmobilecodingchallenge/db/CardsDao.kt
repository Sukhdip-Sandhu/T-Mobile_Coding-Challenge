package com.example.tmobilecodingchallenge.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.tmobilecodingchallenge.models.Cards

@Dao
interface CardsDao {

    @Query("SELECT * FROM cards_table")
    fun getAllCards(): LiveData<List<Cards>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCard(card: Cards)

}