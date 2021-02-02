package com.example.api_flow_recycler_2021.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.api_flow_recycler_2021.model.NewsRepository

class ListViewModel: ViewModel () {

    val newsArticles = NewsRepository().getNewsArticles().asLiveData()
}