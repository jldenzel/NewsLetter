package com.example.newsletter

import com.example.newsletter.data.service.ArticleOnlineService
import com.example.newsletter.models.ArticleResponse

class ArticleRepository {
    private val apiService: ArticleOnlineService

    init {
        apiService = ArticleOnlineService()
    }

    fun getArticles(subject :String): ArticleResponse = apiService.getArticles(subject)

    companion object {
        private var instance: ArticleRepository? = null
        fun getInstance(): ArticleRepository {
            if (instance == null) {
                instance = ArticleRepository()
            }
            return instance!!
        }
    }
}