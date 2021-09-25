package com.example.tmobilecodingchallenge.models


import com.google.gson.annotations.SerializedName

data class Image(
    @SerializedName("url")
    val url: String,
    @SerializedName("size")
    val size: Size
)