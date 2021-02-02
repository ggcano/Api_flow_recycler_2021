package com.example.api_flow_recycler_2021.model

import com.google.gson.annotations.SerializedName

class NewsArticle (
    val author: String? = null,
    val title: String? = null,
    val description: String? = null,
    val url: String? = null,
    @SerializedName("imageUrl")
    val urlToImage: String? = null,
    val publishedAt: String? = null
)