package com.divyansh.newsapp.data.local

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.divyansh.newsapp.data.model.Article

@Dao
interface ArticlesDao {
    @Query("SELECT * FROM news_articles")
    fun getNewsArticles(): PagingSource<Int, Article>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertArticles(articles: List<Article>)

    @Query("DELETE FROM news_articles")
    suspend fun deleteAllArticles()
}