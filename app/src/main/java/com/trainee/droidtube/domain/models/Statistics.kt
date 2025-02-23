package com.trainee.droidtube.domain.models

import kotlinx.serialization.Serializable

@Serializable
data class Statistics(
    val viewCount: Int,
    val likeCount: Int,
    val commentCount: Int,
)
