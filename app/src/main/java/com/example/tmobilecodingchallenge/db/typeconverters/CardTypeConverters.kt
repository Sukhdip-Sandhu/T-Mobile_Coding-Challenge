package com.example.tmobilecodingchallenge.db.typeconverters

import androidx.room.TypeConverter
import com.example.tmobilecodingchallenge.models.Card
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class CardTypeConverters {

    @TypeConverter
    fun fromCardToString(card: Card) : String {
        return Gson().toJson(card)
    }

    @TypeConverter
    fun fromStringToCard(jsonCards: String) : Card {
        val cardTypes = object : TypeToken<Card>(){}.type
        return Gson().fromJson(jsonCards, cardTypes)
    }

}