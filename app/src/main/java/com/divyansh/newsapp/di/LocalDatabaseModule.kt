package com.divyansh.newsapp.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.divyansh.newsapp.data.local.ArticleDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object LocalDatabaseModule {
    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext appContext: Context) = Room.databaseBuilder(
        appContext,
        ArticleDatabase::class.java,
        "news_articles.db"
    )
        .fallbackToDestructiveMigration()
        .build()
}