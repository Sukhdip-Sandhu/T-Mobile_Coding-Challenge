package com.example.tmobilecodingchallenge.repository

import com.example.tmobilecodingchallenge.models.HomePageFeed
import kotlinx.coroutines.flow.Flow

interface HomeFeedRepository {

    fun getHomePageFeed(): Flow<HomePageFeed>
}