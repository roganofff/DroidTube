package com.trainee.droidtube.domain.models

data class Snippet(
    val title: String,
    val description: String,
    val thumbnails: Thumbnail,
    val channelTitle: String,
    val publishedAt: String,
)
