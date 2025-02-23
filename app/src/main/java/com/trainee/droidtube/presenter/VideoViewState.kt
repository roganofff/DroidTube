package com.trainee.droidtube.presenter

import com.trainee.droidtube.domain.models.Video

data class VideoViewState(
    val isLoading: Boolean = false,
    val videos: List<Video> = emptyList(),
    val error: String? = null,
)