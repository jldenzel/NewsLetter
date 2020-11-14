package com.example.newsletter.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.newsletter.R
import com.example.newsletter.models.Article

class ArticleDetailsAdapter (
    items: Article, val handler: ListArticlesHandler
) : RecyclerView.Adapter<ArticleDetailsAdapter.ViewHolder>() {
    private val article: Article = items
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(parent.context)
                .inflate(R.layout.article_details, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.mArticleTitle.text = article.title
        holder.mArticleDescription.text = article.description
        holder.mArticleName.text    = article.author
        holder.mArticleDate.text = article.publish

        // Init favorite button
        if(article.favoritebut == 0){
            holder.mArticleFavorite.setImageResource(R.drawable.ic_baseline_favorite_border_24)
        }else{
            holder.mArticleFavorite.setImageResource(R.drawable.ic_baseline_favorite_24)
        }

        //Button
        holder.mArticleFavorite.setOnClickListener {
            if(article.favoritebut == 0){
                holder.mArticleFavorite.setImageResource(R.drawable.ic_baseline_favorite_24)
                article.favoritebut = 1
            }else{
                holder.mArticleFavorite.setImageResource(R.drawable.ic_baseline_favorite_border_24)
                article.favoritebut = 0
            }
        }
        holder.mArticleRetour.setOnClickListener {
            handler.back()
        }
        holder.mArticleEditeur.text = article.url
        holder.mArticleEditeur.setOnClickListener {
            handler.showPage(article.url)
        }
        val context = holder.itemView.context
        // Display  Avatar
        Glide.with(context)
                .load(article.urlImage)
                .apply(RequestOptions.circleCropTransform())
                .placeholder(R.drawable.ic_baseline_image_24)
                .error(R.drawable.ic_baseline_image_24)
                .skipMemoryCache(false)
                .into(holder.mArticleAvatar)
    }

    override fun getItemCount(): Int {
        return 1
    }

    class ViewHolder(view: View) :
            RecyclerView.ViewHolder(view) {
        val mArticleAvatar: ImageView
        val mArticleName: TextView
        val mArticleDate: TextView
        val mArticleDescription: TextView
        val mArticleRetour : ImageButton
        val mArticleEditeur : TextView
        val mArticleTitle: TextView
        val mArticleFavorite : ImageButton

        init {
            // Enable click on item
            mArticleAvatar = view.findViewById(R.id.item_list_avatar)
            mArticleName = view.findViewById(R.id.item_list_author)
            mArticleDescription = view.findViewById(R.id.item_list_desc)
            mArticleRetour = view.findViewById(R.id.item_back)
            mArticleEditeur = view.findViewById(R.id.item_list_editeur)
            mArticleFavorite = view.findViewById(R.id.item_list_favorite_button)
            mArticleTitle = view.findViewById(R.id.item_list_name)
            mArticleDate = view.findViewById(R.id.item_list_date)
        }
    }
}


