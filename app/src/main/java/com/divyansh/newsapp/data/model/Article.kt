package com.divyansh.newsapp.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "news_articles")
data class Article(
    @ColumnInfo
    val publishedAt: String?,
    val source: Source?,
    val title: String?,
    @PrimaryKey
    val url: String,
    val urlToImage: String?
)