package com.example.tmobilecodingchallenge.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.tmobilecodingchallenge.db.typeconverters.CardTypeConverters
import com.example.tmobilecodingchallenge.models.Cards

@Database(
    entities = [Cards::class],
    version = 1
)

@TypeConverters(CardTypeConverters::class)
abstract class CardsDatabase : RoomDatabase() {
    abstract fun getCardsDao(): CardsDao
}