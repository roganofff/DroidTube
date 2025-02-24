package com.trainee.droidtube.data.repository

import com.trainee.droidtube.data.models.VideoDto
import com.trainee.droidtube.domain.models.VideoPage
import com.trainee.droidtube.domain.VideoRepository
import com.trainee.droidtube.domain.models.VideoDetails
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import javax.inject.Inject

class VideoRepositoryImpl @Inject constructor(
    private val api: HttpClient
) : VideoRepository {
    override suspend fun getVideoList(q: String?, type: String, key: String, pageToken: String?): VideoPage {
        val requestQuery = "search?key=$key&type=$type&q=${q ?: ""}&pageToken=${pageToken ?: ""}"
        return api.get(requestQuery).body()
    }

    override suspend fun getVideoDetails(id: String, key: String): VideoDetails {
        val requestQuery = "videos?part=snippet%2CcontentDetails%2Cstatistics&id=$id&key=$key"
        val videoDetails = (api.get(requestQuery).body() as VideoDto).items[0]
        return videoDetails
    }
}