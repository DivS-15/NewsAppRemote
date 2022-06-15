package com.divyansh.newsapp.data.repository

import androidx.paging.*
import com.divyansh.newsapp.data.local.ArticleDatabase
import com.divyansh.newsapp.data.model.Article
import com.divyansh.newsapp.data.remote.NewsApiInterface
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class NewsRepository @Inject constructor(
    private val database: ArticleDatabase,
    private val service: NewsApiInterface
) {
    @OptIn(ExperimentalPagingApi::class)
    fun getTopHeadlinesPagingData(): Flow<PagingData<Article>> {
        return Pager(
            PagingConfig(
                pageSize = 20,
                enablePlaceholders = false
            ),
            pagingSourceFactory = {database.articlesDao().getNewsArticles()},
            remoteMediator = NewsRemoteMediator(service, database)
        ).flow
    }
}