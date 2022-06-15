package com.divyansh.newsapp.ui

import android.content.Context
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.browser.customtabs.CustomTabsIntent
import androidx.core.net.toUri
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.RoundedCornersTransformation
import com.divyansh.newsapp.data.model.Article
import com.divyansh.newsapp.databinding.ListItemBinding
import com.divyansh.newsapp.util.getDateTimeDifference

class NewsListAdapter : PagingDataAdapter<Article, NewsListAdapter.NewsViewHolder>(DiffCallback) {

    inner class NewsViewHolder(
        private val binding: ListItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        init {
            binding.apply {
                root.setOnClickListener {
                    val position = absoluteAdapterPosition
                    val newsItem = getItem(position)
                    if (newsItem != null) {
                        openNewsArticleInChrome(newsItem.url, itemView.context)
                    }
                }


            }
        }
        fun bind(article: Article) {
            binding.apply {

                val date = getDateTimeDifference(article.publishedAt.toString())

                newsTitle.text = article.title
                source.text = article.source?.name

                if (date.days.toInt() == 0) {
                    timePublished.text = "${date.hours} hours ago"
                }

                if (date.hours.toInt() == 0) {
                    timePublished.text = "${date.minutes} minutes ago"
                } else if (date.minutes.toInt() == 0) {
                    timePublished.text = "${date.seconds} seconds ago"
                }


                val imgUrl = article.urlToImage

                imgUrl?.let {
                    val imgUri = imgUrl.toUri().buildUpon().scheme("https").build()
                    newsImage.load(imgUri) {
                        transformations(RoundedCornersTransformation(20f))
                    }
                }
            }
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<Article>() {
        override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean {
            TODO("Not yet implemented")
        }

        override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean {
            TODO("Not yet implemented")
        }

    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val currentItem = getItem(position)
        if (currentItem != null) {
            holder.bind(currentItem)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val binding =
            ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NewsViewHolder(binding)
    }

    private fun openNewsArticleInChrome(url: String, context: Context) {
        val builder: CustomTabsIntent.Builder = CustomTabsIntent.Builder()
        val customTabsIntent = builder.build()
        customTabsIntent.launchUrl(context, Uri.parse(url))
    }
}