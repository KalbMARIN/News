package com.practicum.news.data.remote


import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApiService {

    @GET("v2/everything?apiKey=0fb957a5659c40c5a530497e4b202e85")
    suspend fun loadArticles(
        @Query("q") topic: String
    ): NewsResponseDto
}