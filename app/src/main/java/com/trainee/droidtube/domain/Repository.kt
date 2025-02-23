package com.trainee.droidtube.domain

import com.trainee.droidtube.domain.models.VideoDetails
import com.trainee.droidtube.domain.models.VideoPage

interface Repository {
    suspend fun getVideoList(q: String?, type: String = "video", key: String, pageToken: String?) : VideoPage

    suspend fun getVideoDetails(id: String, key: String) : VideoDetails
}