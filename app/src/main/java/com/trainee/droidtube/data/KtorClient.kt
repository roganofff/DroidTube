package com.trainee.droidtube.data

import com.trainee.droidtube.domain.models.VideoDetails
import com.trainee.droidtube.domain.models.VideoPage
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.okhttp.OkHttp
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.plugins.logging.SIMPLE
import io.ktor.client.request.get
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

class KtorClient {
    private val client = HttpClient(OkHttp) {
        defaultRequest { url("https://youtube.googleapis.com/youtube/v3/") }

        install(Logging) {
            logger = Logger.SIMPLE
        }

        install(ContentNegotiation) {
            json(Json {
                ignoreUnknownKeys = true
            })
        }
    }

    suspend fun getVideosPage(q: String, type: String, pageToken: String, key: String) : VideoPage {
        val requestQuery = "search?key=$key&type=$type&q=$q&pageToken=$pageToken"
        return client.get(requestQuery).body()
    }

    suspend fun getVideoDetails(id: String, key: String) : VideoDetails {
        val requestQuery = "videos?part=snippet%2CcontentDetails%2Cstatistics&id=$id&key=$key"
        return client.get(requestQuery).body()
    }
}