package com.trainee.droidtube.presenter

import com.trainee.droidtube.domain.models.VideoDetails

sealed class VideoIntent {
    data class LoadVideos(val q: String) : VideoIntent()
    data class WatchVideo(val video: VideoDetails) : VideoIntent()
    data class RefreshVideos(val query: String) : VideoIntent()
}