package com.trainee.droidtube.presenter.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.trainee.droidtube.R
import com.trainee.droidtube.databinding.ListFragmentBinding
import com.trainee.droidtube.presenter.ListViewModel
import com.trainee.droidtube.presenter.VideoIntent
import com.trainee.droidtube.presenter.fragments.adapter.VideoAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class ListFragment : Fragment(R.layout.list_fragment) {
    private var _binding: ListFragmentBinding? = null
    private val binding get() = _binding!!

    private val viewModel by viewModels<ListViewModel>()

    private lateinit var adapter: VideoAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = ListFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = VideoAdapter(mutableListOf()) { video ->
            lifecycleScope.launch {
                viewModel.intentChannel.send(VideoIntent.WatchVideo(video))
            }
        }

        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.adapter = adapter

        lifecycleScope.launch {
            viewModel.state.collect { state ->
                if (state.isLoading) {
                    binding.progressBar.visibility = View.VISIBLE
                } else {
                    binding.progressBar.visibility = View.GONE
                }

                state.error?.let { error ->
                    Log.d("ERROR", error)
                }

                Log.d("FRAG", "Adding ${state.videos}")
                adapter.addVideos(state.videos)
            }
        }

        lifecycleScope.launch {
//            val searchRequest = binding.searchField.text.toString()
            val searchRequest = "video 1 day long"
            viewModel.intentChannel.send(VideoIntent.LoadVideos(q = searchRequest))
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}