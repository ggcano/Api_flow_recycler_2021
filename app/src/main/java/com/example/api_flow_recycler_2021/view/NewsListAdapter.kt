package com.example.api_flow_recycler_2021.view


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.api_flow_recycler_2021.databinding.ItemNewsArticleBinding

import com.example.api_flow_recycler_2021.model.NewsArticle

class NewsListAdapter: RecyclerView.Adapter<NewsListAdapter.NewsItemViewHolder>() {
    private val newsItems = arrayListOf<NewsArticle>()


    fun onAddNewsItem(item: NewsArticle) {
        newsItems.add(0, item)
        notifyItemInserted(0)
    }

    fun onDeleteItem(position: Int) {
        newsItems.removeAt(position)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsItemViewHolder {
        val binding = ItemNewsArticleBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NewsItemViewHolder(binding)
    }

    override fun getItemCount() = newsItems.size

    override fun onBindViewHolder(holder: NewsItemViewHolder, position: Int) {
        holder.bind(newsItems[position], position)

    }

    inner class NewsItemViewHolder(viewBinding: ItemNewsArticleBinding) : RecyclerView.ViewHolder(viewBinding.root) {

        private val imageView = viewBinding.newsImage
        private val author = viewBinding.newsAuthor
        private val title = viewBinding.newsTitle
        private val publishedAt = viewBinding.newsPublishedAt
        private val cardView = viewBinding.cardview


        fun bind(newsItem: NewsArticle, position: Int) {
            imageView.loadImage(newsItem.urlToImage)
            author.text = newsItem.author
            title.text = newsItem.title
            publishedAt.text = newsItem.publishedAt
            cardView.setOnClickListener {
                onDeleteItem(position)
            }

        }
    }

}