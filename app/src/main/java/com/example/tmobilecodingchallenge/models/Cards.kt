package com.example.tmobilecodingchallenge.models


import com.google.gson.annotations.SerializedName

data class Cards(
    @SerializedName("card")
    val card: Card,
    @SerializedName("card_type")
    val cardType: String
)