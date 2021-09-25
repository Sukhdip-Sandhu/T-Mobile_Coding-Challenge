package com.example.tmobilecodingchallenge.models


import com.google.gson.annotations.SerializedName

data class Card(
    @SerializedName("value")
    val value: String?,
    @SerializedName("attributes")
    val attributes: Attributes?,
    @SerializedName("title")
    val title: Title?,
    @SerializedName("description")
    val description: Description?,
    @SerializedName("image")
    val image: Image?
)