package com.divyansh.newsapp.di

import com.divyansh.newsapp.data.remote.NewsApiInterface
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object NetworkModule {
    private val moshi = Moshi.Builder().addLast(KotlinJsonAdapterFactory()).build()

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit =
        Retrofit.Builder().baseUrl(NewsApiInterface.BASE_URL).addConverterFactory(
            MoshiConverterFactory.create(
                moshi
            )
        ).build()

    @Provides
    @Singleton
    fun provideNewsApiInterface(retrofit: Retrofit): NewsApiInterface =
        retrofit.create(NewsApiInterface::class.java)
}