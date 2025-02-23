package com.trainee.droidtube.domain.models

import kotlinx.serialization.Serializable

@Serializable
data class Snippet(
    val title: String,
    val description: String,
    val thumbnails: Thumbnail,
    val channelTitle: String,
    val publishedAt: String,
)
