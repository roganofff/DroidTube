package com.trainee.droidtube.data.repository

import com.trainee.droidtube.data.KtorClient
import com.trainee.droidtube.domain.models.VideoPage
import com.trainee.droidtube.domain.Repository
import com.trainee.droidtube.domain.models.VideoDetails
import io.ktor.client.call.body
import io.ktor.client.request.get
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val ktorClient: KtorClient
) : Repository {
    override suspend fun getVideoList(q: String?, type: String, key: String, pageToken: String?): VideoPage {
        val requestQuery = "search?key=$key&type=$type&q=$q&pageToken=$pageToken"
        return ktorClient.api.get(requestQuery).body()
    }

    override suspend fun getVideoDetails(id: String, key: String): VideoDetails {
        val requestQuery = "videos?part=snippet%2CcontentDetails%2Cstatistics&id=$id&key=$key"
        return ktorClient.api.get(requestQuery).body()
    }
}