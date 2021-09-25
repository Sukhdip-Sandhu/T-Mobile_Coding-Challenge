package com.example.tmobilecodingchallenge.api

import com.example.tmobilecodingchallenge.models.HomePageFeed
import retrofit2.http.GET

interface HomePageFeedApi {

    @GET("home")
    suspend fun getHomePageFeed() : HomePageFeed
}