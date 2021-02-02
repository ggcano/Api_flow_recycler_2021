package com.example.api_flow_recycler_2021.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.api_flow_recycler_2021.R
import com.example.api_flow_recycler_2021.model.NewsArticle

class NewsListAdapter: RecyclerView.Adapter<NewsListAdapter.NewsItemViewHolder>() {
    private val newsItems = arrayListOf<NewsArticle>()


    fun onAddNewsItem(item: NewsArticle) {
        newsItems.add(0, item)
        notifyItemInserted(0)
    }

    fun onDeleteItem (position: Int){
        newsItems.removeAt(position)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int) = NewsItemViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_news_article, parent, false)
    )

    override fun getItemCount() = newsItems.size

    override fun onBindViewHolder(holder: NewsItemViewHolder, position: Int) {
        holder.bind(newsItems[position], position)
    }

    inner class NewsItemViewHolder(view: View): RecyclerView.ViewHolder(view) {

        private val imageView = view.newsImage
        private val author = view.newsAuthor
        private val title = view.newsTitle
        private val publishedAt = view.newsPublishedAt
        private val cardView = view.cardview


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