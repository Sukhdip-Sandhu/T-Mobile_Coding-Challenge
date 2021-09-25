package com.example.tmobilecodingchallenge.models


import com.google.gson.annotations.SerializedName

data class HomePageFeed(
    @SerializedName("page")
    val page: Page
)