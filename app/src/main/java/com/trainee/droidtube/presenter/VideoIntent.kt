package com.trainee.droidtube.presenter

import com.trainee.droidtube.domain.models.Video

sealed class VideoIntent {
    data object LoadVideos : VideoIntent()
    data class WatchVideo(val video: Video) : VideoIntent()
    data class RefreshVideos(val query: String) : VideoIntent()
}