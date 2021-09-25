package com.example.tmobilecodingchallenge.ui.fragments.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tmobilecodingchallenge.models.HomePageFeed
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

    private val _viewState = MutableLiveData<ViewState>()
    val viewState : LiveData<ViewState> = _viewState

    init {
        getHomePageFeed()
    }

    private fun getHomePageFeed() {
        viewModelScope.launch {
            homeFeedRepository.getHomePageFeed()
                .onStart {
                    _viewState.value = ViewState.Loading
                }
                .catch {
                    _viewState.value = ViewState.Error("An unknown error occurred")
                }
                .collect { homePageFeed ->
                    _viewState.value = ViewState.Success(homePageFeed)
                }
        }
    }

    sealed class ViewState {
        object Loading: ViewState()
        data class Success(val homePageFeed: HomePageFeed): ViewState()
        data class Error(val error: String): ViewState()
    }

}