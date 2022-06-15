package com.divyansh.newsapp.data.remote

import com.divyansh.newsapp.BuildConfig
import com.divyansh.newsapp.data.model.TopHeadlines
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface NewsApiInterface {
    companion object {
        const val BASE_URL = "https://newsapi.org/"
        const val KEY = BuildConfig.ACCESS_KEY
    }

    @Headers("X-Api-Key: $KEY ")
    @GET("v2/top-headlines")
    suspend fun getTopHeadlines(
        @Query("page") page: Int,
        @Query("pageSize") pageSize: Int,
        @Query("language") language: String = "en"
    ): TopHeadlines
}