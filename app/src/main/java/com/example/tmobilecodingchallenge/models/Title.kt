package com.example.tmobilecodingchallenge.models


import com.google.gson.annotations.SerializedName

data class Title(
    @SerializedName("value")
    val value: String,
    @SerializedName("attributes")
    val attributes: Attributes
)