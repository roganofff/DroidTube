package com.trainee.droidtube.data.repository

import com.trainee.droidtube.domain.models.VideoPage
import com.trainee.droidtube.domain.Repository
import com.trainee.droidtube.domain.models.Video
import com.trainee.droidtube.domain.models.VideoDetails

class RepositoryImpl : Repository {
    override suspend fun getVideoList(q: String?, type: String, key: String): VideoPage {
//        return api.getVideos(q = q, type = type, key = key)
        return VideoPage(
            videos = TODO(),
            nextPageToken = TODO(),
            prevPageToken = TODO()
        )
    }

    override suspend fun getVideoInfo(id: String, key: String): VideoDetails {
        TODO("Not yet implemented")
    }
}