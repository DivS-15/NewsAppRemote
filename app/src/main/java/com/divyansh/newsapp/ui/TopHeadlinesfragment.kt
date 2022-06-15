package com.divyansh.newsapp.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.divyansh.newsapp.R
import com.divyansh.newsapp.databinding.TopHeadlinesFragmentBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class TopHeadlinesFragment() : Fragment(R.layout.top_headlines_fragment) {

    private var _binding: TopHeadlinesFragmentBinding? = null
    private val binding get() = _binding!!
    private val viewModel: NewsViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = TopHeadlinesFragmentBinding.bind(view)
        val adapter = NewsListAdapter()

        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.newsArticles.collectLatest {
                    adapter.submitData(it)
                }
            }
        }
    }
}