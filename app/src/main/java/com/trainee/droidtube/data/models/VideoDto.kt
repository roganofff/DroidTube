package com.trainee.droidtube.data.models

import com.trainee.droidtube.domain.models.VideoDetails
import kotlinx.serialization.Serializable

@Serializable
data class VideoDto(
    val items: List<VideoDetails>,
)
