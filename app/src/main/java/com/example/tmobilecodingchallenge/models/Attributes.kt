package com.example.tmobilecodingchallenge.models


import com.google.gson.annotations.SerializedName

data class Attributes(
    @SerializedName("font")
    val font: Font,
    @SerializedName("text_color")
    val textColor: String
)