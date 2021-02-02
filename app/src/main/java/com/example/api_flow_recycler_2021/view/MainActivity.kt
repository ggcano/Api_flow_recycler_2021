package com.example.api_flow_recycler_2021.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.api_flow_recycler_2021.R
import com.example.api_flow_recycler_2021.databinding.ActivityMainBinding
import com.example.api_flow_recycler_2021.viewmodel.ListViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var viewModel: ListViewModel
    private val newsListAdapter = NewsListAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        viewModel = ViewModelProviders.of(this).get(ListViewModel::class.java)

        binding.newsList.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = newsListAdapter
        }

        observeViewModel()
    }

    private fun observeViewModel() {
        viewModel.newsArticles.observe(this, Observer { article ->
            binding.loadingView.visibility = View.GONE
            binding.newsList.visibility = View.VISIBLE
            newsListAdapter.onAddNewsItem(article)
            //  newsList.smoothScrollToPosition(0)
        })
    }
}