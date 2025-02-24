package com.trainee.droidtube.data.mapper

import android.util.Log
import com.trainee.droidtube.BuildConfig.API_KEY
import com.trainee.droidtube.domain.VideoRepository
import com.trainee.droidtube.domain.models.ContentDetails
import com.trainee.droidtube.domain.models.Video
import com.trainee.droidtube.domain.models.VideoDetails
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.coroutineScope
import kotlin.time.Duration

fun Video.provideDetails(details: VideoDetails) : VideoDetails = VideoDetails(
    id = this.id.videoId,
    snippet = details.snippet,
    contentDetails = details.contentDetails,
    statistics = details.statistics,
)

suspend fun List<Video>.fetchDetailsAndMap(
    repository: VideoRepository
): List<VideoDetails> = coroutineScope {
    this@fetchDetailsAndMap.map { video ->
        async {
            val details = repository.getVideoDetails(video.id.videoId, key = API_KEY)
            Log.d("5OPKA", details.toString())
            video.provideDetails(details)
        }
    }.awaitAll()
}

fun ContentDetails.convertToHMS() : String = Duration.parseIsoString(duration).toString()
