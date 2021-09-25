package com.example.tmobilecodingchallenge.repository

import com.example.tmobilecodingchallenge.api.HomePageFeedApi
import com.example.tmobilecodingchallenge.models.HomePageFeed
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class HomeFeedRepositoryImpl @Inject constructor(
    private val homePageFeedApi: HomePageFeedApi
) : HomeFeedRepository {

    override fun getHomePageFeed(): Flow<HomePageFeed> {
        return flow {
            val response = homePageFeedApi.getHomePageFeed()
            emit(response)
        }
    }

}