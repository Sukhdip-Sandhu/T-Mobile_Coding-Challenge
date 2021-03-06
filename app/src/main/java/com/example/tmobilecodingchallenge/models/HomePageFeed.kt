package com.example.tmobilecodingchallenge.models


import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.tmobilecodingchallenge.db.typeconverters.CardTypeConverters
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class HomePageFeed(
    @SerializedName("page")
    val page: Page
)

data class Page(
    @SerializedName("cards")
    val cards: List<Cards>
)

@Entity(tableName = "cards_table")
data class Cards(
    @PrimaryKey(autoGenerate = true)
    val id: Int,

    @TypeConverters(CardTypeConverters::class)
    @SerializedName("card")
    val card: Card,

    @SerializedName("card_type")
    val cardType: String
) : Serializable