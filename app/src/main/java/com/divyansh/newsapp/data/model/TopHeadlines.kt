package com.divyansh.newsapp.data.model

data class TopHeadlines(
    val articles: List<Article>,
    val status: String?,
    val totalResults: Int?
)