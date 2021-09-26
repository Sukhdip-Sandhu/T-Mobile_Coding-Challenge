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

data class Attributes(
    @SerializedName("font")
    val font: Font,
    @SerializedName("text_color")
    val textColor: String
)

data class Font(
    @SerializedName("size")
    val size: Int
)

data class Title(
    @SerializedName("value")
    val value: String,
    @SerializedName("attributes")
    val attributes: Attributes
)

data class Description(
    @SerializedName("value")
    val value: String,
    @SerializedName("attributes")
    val attributes: Attributes
)

data class Image(
    @SerializedName("url")
    val url: String,
    @SerializedName("size")
    val size: Size
)

data class Size(
    @SerializedName("height")
    val height: Int,
    @SerializedName("width")
    val width: Int
)