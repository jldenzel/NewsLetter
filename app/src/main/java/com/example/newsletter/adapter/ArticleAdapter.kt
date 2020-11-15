package com.example.newsletter.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.newsletter.R
import com.example.newsletter.models.Article
import com.example.newsletter.models.ArticleResponse


class ArticleAdapter(
    items: ArticleResponse, val handler: ListArticlesHandler
) : RecyclerView.Adapter<ArticleAdapter.ViewHolder>() {
    private val mArticles: ArticleResponse = items
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.articles_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val article: Article = mArticles.articles[position]
        // Display Neighbour Name
        holder.mArticleTitle.text = article.title
        holder.mArticleDescription.text = article.description
        holder.mArticleName.text    = article.author
        holder.mArticleDate.text = article.publish
        //init favorite button
        // Init favorite button
        if(article.favoritebut == 0){
            holder.mArticleFavorite.setImageResource(R.drawable.ic_baseline_favorite_border_24)
        }else{
            holder.mArticleFavorite.setImageResource(R.drawable.ic_baseline_favorite_24)
        }


        holder.mArticleTitle.setOnClickListener {
            handler.showArticle(article)
        }
        holder.mArticleDescription.setOnClickListener {
            handler.showArticle(article)
        }
        holder.mArticleFavorite.setOnClickListener {
            if (article.favoritebut == 0 ){
                holder.mArticleFavorite.setImageResource(R.drawable.ic_baseline_favorite_24)
                article.favoritebut = 1
            }
            else
            {
                article.favoritebut = 0
                holder.mArticleFavorite.setImageResource(R.drawable.ic_baseline_favorite_border_24)
            }
        }
        holder.mArticleAvatar.setOnClickListener {
            handler.showArticle(article)
        }
        val context = holder.itemView.context
        // Display  Avatar
        Glide.with(context)
            .load(article.urlImage)
            .placeholder(R.drawable.ic_baseline_image_24)
            .error(R.drawable.ic_baseline_image_24)
            .skipMemoryCache(false)
            .into(holder.mArticleAvatar)
    }

    override fun getItemCount(): Int {
        return mArticles.articles.size
    }

    class ViewHolder(view: View) :
        RecyclerView.ViewHolder(view) {
        val mArticleAvatar: ImageView
        val mArticleName: TextView
        val mArticleTitle: TextView
        val mArticleDate: TextView
        val mArticleDescription: TextView
        val mArticleFavorite: ImageButton

        init {
            // Enable click on item
            mArticleAvatar = view.findViewById(R.id.item_list_avatar)
            mArticleName = view.findViewById(R.id.item_list_author)
            mArticleTitle = view.findViewById(R.id.item_list_name)
            mArticleDate = view.findViewById(R.id.item_list_date)
            mArticleDescription = view.findViewById(R.id.item_list_desc)
            mArticleFavorite = view.findViewById(R.id.item_list_favorite_button)
        }
    }
}