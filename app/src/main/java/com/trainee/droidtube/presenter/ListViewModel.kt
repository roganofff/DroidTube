package com.trainee.droidtube.presenter

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.trainee.droidtube.BuildConfig.API_KEY
import com.trainee.droidtube.data.mapper.fetchDetailsAndMap
import com.trainee.droidtube.domain.VideoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.consumeAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListViewModel @Inject constructor(
    private val repository: VideoRepository
) : ViewModel() {
    val intentChannel = Channel<VideoIntent>(Channel.UNLIMITED)

    private val _state = MutableStateFlow(VideoViewState())
    val state: StateFlow<VideoViewState> = _state

    private var pageToken: String? = null

    init {
        handeIntents()
    }

    private fun handeIntents() {
        viewModelScope.launch {
            intentChannel.consumeAsFlow().collect { intent ->
                when (intent) {
                    is VideoIntent.LoadVideos -> loadVideos(intent.q)
                    is VideoIntent.WatchVideo -> watchVideo()
                    is VideoIntent.RefreshVideos -> updateList()
                }
            }
        }
    }

    private suspend fun loadVideos(q: String) {
        _state.value = _state.value.copy(
            isLoading = true,
            error = null,
        )
        try {
            val response = repository.getVideoList(q = q, key = API_KEY, pageToken = pageToken)
            Log.d("STARYY BOG", response.toString())
            _state.value = _state.value.copy(
                videos = response.videos.fetchDetailsAndMap(repository),
                isLoading = false,
                error = null,
            )
            pageToken = response.nextPageToken
        } catch (e: Exception) {
            _state.value = _state.value.copy(
                isLoading = false,
                error = e.message,
            )
        }
    }

    private suspend fun watchVideo() {
        TODO("Not yet implemented")
    }

    private suspend fun updateList() {
        TODO("Not yet implemented")
    }
}