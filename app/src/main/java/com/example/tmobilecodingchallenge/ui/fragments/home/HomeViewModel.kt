package com.example.tmobilecodingchallenge.ui.fragments.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tmobilecodingchallenge.models.HomePageFeed
import com.example.tmobilecodingchallenge.repository.HomeFeedRepository
import com.example.tmobilecodingchallenge.repository.HomeFeedRepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val homeFeedRepository: HomeFeedRepositoryImpl
) : ViewModel() {

    init {
        getHomePageFeed()
    }

    private fun getHomePageFeed() {
        viewModelScope.launch {
            homeFeedRepository.getHomePageFeed()
                .onStart {

                }
                .catch {

                }
                .collect { homePageFeed ->

                }
        }
    }

}