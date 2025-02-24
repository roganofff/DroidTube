package com.trainee.droidtube.presenter.fragments.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.trainee.droidtube.databinding.VideoItemBinding
import com.trainee.droidtube.domain.models.VideoDetails

class VideoAdapter(
    private var videos: List<VideoDetails>,
    private val onVideoClicked: (VideoDetails) -> Unit
) : RecyclerView.Adapter<VideoAdapter.VideoViewHolder>() {

    inner class VideoViewHolder(
        private val binding: VideoItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(video: VideoDetails) {
            binding.videoTitle.text = video.snippet.title
            binding.videoDuration.text = video.contentDetails.duration
            loadThumbnail(video.snippet.thumbnails.high.url)

            binding.root.setOnClickListener {
                onVideoClicked(video)
            }
        }

        private fun loadThumbnail(url: String) {
            Glide.with(binding.videoPreview.context)
                .load(url)
                .into(binding.videoPreview)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoViewHolder {
        val binding = VideoItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return VideoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: VideoViewHolder, position: Int) {
        holder.bind(videos[position])
    }

    override fun getItemCount(): Int = videos.size


}