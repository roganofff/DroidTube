package com.trainee.droidtube.domain.models

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class VideoPage(
    @SerializedName("items")
    val videos: List<Video>,
    val nextPageToken: String,
    val prevPageToken: String,
)
