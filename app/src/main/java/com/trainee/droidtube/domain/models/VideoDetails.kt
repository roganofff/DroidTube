package com.trainee.droidtube.domain.models

import kotlinx.serialization.Serializable

@Serializable
data class VideoDetails(
    val id: String,
    val snippet: Snippet,
    val contentDetails: ContentDetails,
    val statistics: Statistics,
)
