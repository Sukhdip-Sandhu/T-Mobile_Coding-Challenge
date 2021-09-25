package com.example.tmobilecodingchallenge.models


import com.google.gson.annotations.SerializedName

data class Description(
    @SerializedName("value")
    val value: String,
    @SerializedName("attributes")
    val attributes: Attributes
)