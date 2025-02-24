package com.trainee.droidtube.presenter.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
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

        adapter = VideoAdapter(emptyList()) { video ->
            lifecycleScope.launch {
                viewModel.intentChannel.send(VideoIntent.WatchVideo(video))
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}