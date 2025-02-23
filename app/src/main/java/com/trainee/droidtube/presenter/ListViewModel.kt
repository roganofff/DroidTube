package com.trainee.droidtube.presenter

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
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

    init {
        handeIntents()
    }

    private fun handeIntents() {
        viewModelScope.launch {
            intentChannel.consumeAsFlow().collect { intent ->

            }
        }
    }
}