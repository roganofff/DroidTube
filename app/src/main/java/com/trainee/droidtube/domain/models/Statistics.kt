package com.trainee.droidtube.domain.models

import kotlinx.serialization.Serializable

@Serializable
data class Statistics(
    val viewCount: Int? = null,
    val likeCount: Int? = null,
    val commentCount: Int? = null,
)
