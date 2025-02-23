package com.trainee.droidtube.data

import com.trainee.droidtube.domain.models.VideoDetails
import com.trainee.droidtube.domain.models.VideoPage
import retrofit2.http.GET
import retrofit2.http.Query

interface YouTubeApi {
    @GET
    suspend fun getVideoList(
        @Query("q") q: String,
        @Query("type") type: String = "video",
        @Query("key") key: String,
    ) : VideoPage

    @GET
    suspend fun getVideoInfo(
        @Query("id") id: String,
        @Query("key") key: String,
    ) : VideoDetails
}