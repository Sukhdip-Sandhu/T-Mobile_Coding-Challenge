package com.example.tmobilecodingchallenge.di

import android.content.Context
import androidx.room.Room
import com.example.tmobilecodingchallenge.db.CardsDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(
        context.applicationContext,
        CardsDatabase::class.java,
        "cards_database.db"
    ).build()

    @Singleton
    @Provides
    fun provideDao(
        database: CardsDatabase
    ) = database.getCardsDao()

}