package com.trainee.droidtube.domain.models

import kotlinx.serialization.Serializable

@Serializable
data class VideoPage(
    val items: List<Video> = emptyList(),
    val nextPageToken: String,
)
