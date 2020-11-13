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
    /*This method will update our recycleView with the element at the position given
    in the parameter. In order to load into memory only the elements displayed on the screen.*/
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val article: Article = mArticles.articles[position]

        holder.mArticleDate.text = article.publish
        holder.mArticleName.text = article.author
        holder.mArticleTitle.text = article.title
        holder.mArticleDesc.text = article.description
        // Init favorite button
        if(article.favoritebut == 0){
            holder.mArticleFavorite.setImageResource(R.drawable.ic_baseline_favorite_border_24)
        }else{
            holder.mArticleFavorite.setImageResource(R.drawable.ic_baseline_favorite_24)
        }

        holder.mArticleTitle.setOnClickListener {
            handler.showArticle(article)
        }
        holder.mArticleDesc.setOnClickListener {
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
        // Display Avatar
        Glide.with(context)
            .load(article.urlImage)
            .placeholder(R.drawable.ic_baseline_image_24)
            .error(R.drawable.ic_baseline_image_24)
            .skipMemoryCache(false)
            .into(holder.mArticleAvatar)
    }
    //This function will return the total number of items in our recycleView.
    override fun getItemCount(): Int {
        return mArticles.articles.size
    }

    class ViewHolder(view: View) :
        RecyclerView.ViewHolder(view) {
        val mArticleAvatar: ImageView
        val mArticleName: TextView
        val mArticleTitle: TextView
        val mArticleDate: TextView
        val mArticleDesc: TextView
        val mArticleFavorite: ImageButton

        init {
            // Enable click on item
            mArticleDesc = view.findViewById(R.id.item_list_desc)
            mArticleTitle = view.findViewById(R.id.item_list_name)
            mArticleAvatar = view.findViewById(R.id.item_list_avatar)
            mArticleName = view.findViewById(R.id.item_list_author)
            mArticleFavorite = view.findViewById(R.id.item_list_favorite_button)
            mArticleDate = view.findViewById(R.id.item_list_date)
        }
    }
}