package com.example.tmobilecodingchallenge.ui.fragments.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.tmobilecodingchallenge.repository.HomeFeedRepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    homeFeedRepository: HomeFeedRepositoryImpl
) : ViewModel() {

    val cards = homeFeedRepository.getHomePageFeed().asLiveData()
}