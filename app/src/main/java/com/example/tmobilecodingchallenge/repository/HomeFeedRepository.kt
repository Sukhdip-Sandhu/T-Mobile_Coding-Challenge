package com.example.tmobilecodingchallenge.repository

import com.example.tmobilecodingchallenge.models.Cards
import com.example.tmobilecodingchallenge.util.Resource
import kotlinx.coroutines.flow.Flow

interface HomeFeedRepository {

    fun getHomePageFeed(): Flow<Resource<List<Cards>>>
}