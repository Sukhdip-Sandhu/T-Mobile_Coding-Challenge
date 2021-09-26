package com.example.tmobilecodingchallenge.repository

import com.example.tmobilecodingchallenge.api.HomePageFeedApi
import com.example.tmobilecodingchallenge.db.CardsDao
import com.example.tmobilecodingchallenge.util.networkBoundResource
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class HomeFeedRepositoryImpl @Inject constructor(
    private val homePageFeedApi: HomePageFeedApi,
    private val dao: CardsDao
) : HomeFeedRepository {

    override fun getHomePageFeed() = networkBoundResource(
        query = {
            dao.getAllCards()
        },
        fetch = {
            homePageFeedApi.getHomePageFeed()
        },
        saveFetchResult = { homePageFeed ->
            // in a real app should use database transactions!
            dao.deleteAllCards()
            dao.insertCards(homePageFeed.page.cards)
        },
        shouldFetch = {
            true // shouldFetch logic based off business requirements. For now, always fetch
        }
    )

}