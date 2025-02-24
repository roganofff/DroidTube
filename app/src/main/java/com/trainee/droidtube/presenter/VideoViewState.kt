package com.trainee.droidtube.presenter

import com.trainee.droidtube.domain.models.VideoDetails

data class VideoViewState(
    val isLoading: Boolean = false,
    val videos: List<VideoDetails> = emptyList(),
    val error: String? = null,
)