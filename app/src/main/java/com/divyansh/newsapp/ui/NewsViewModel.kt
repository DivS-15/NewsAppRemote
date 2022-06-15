package com.divyansh.newsapp.ui

import androidx.lifecycle.ViewModel
import com.divyansh.newsapp.data.repository.NewsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(
    private val repository: NewsRepository
) : ViewModel() {
    val newsArticles = repository.getTopHeadlinesPagingData()
}