package com.trainee.droidtube.domain.models

data class VideoDetails(
    val videoId: String,
    val snippet: Snippet,
    val contentDetails: ContentDetails,
    val statistics: Statistics,
)
