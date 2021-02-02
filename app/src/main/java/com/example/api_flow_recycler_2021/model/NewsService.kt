package com.example.api_flow_recycler_2021.model

import retrofit2.http.GET

interface NewsService {
    @GET("news.json")
    suspend fun getNews(): List<NewsArticle>
}