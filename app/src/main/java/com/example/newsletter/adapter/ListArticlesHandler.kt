package com.example.newsletter.adapter

import com.example.newsletter.models.Article

interface ListArticlesHandler {
    fun showArticle(article: Article)
    fun back()
}