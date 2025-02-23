package com.trainee.droidtube.domain.models

import kotlinx.serialization.Serializable

@Serializable
data class Video(
    val etag: String,
    val id: VideoDetails,
)
