package com.divyansh.newsapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.divyansh.newsapp.data.model.Article
import com.divyansh.newsapp.data.model.RemoteKeys

@Database(
    entities = [Article::class, RemoteKeys::class],
    version = 2,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class ArticleDatabase : RoomDatabase() {
    abstract fun articlesDao(): ArticlesDao
    abstract fun remoteKeysDao(): RemoteKeyDao
}