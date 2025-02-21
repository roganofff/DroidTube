package com.trainee.droidtube.domain

import com.trainee.droidtube.domain.models.VideoDetails
import com.trainee.droidtube.domain.models.VideoPage

interface Repository {
    suspend fun getVideoList(q: String?, type: String = "video", key: String) : VideoPage

    suspend fun getVideoInfo(id: String, key: String) : VideoDetails
}