package com.trainee.droidtube.domain.models

import kotlinx.serialization.Serializable

@Serializable
data class VideoDetails(
    val videoId: String,
    val snippet: Snippet,
    val contentDetails: ContentDetails,
    val statistics: Statistics,
)
