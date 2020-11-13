package com.example.newsletter.data.service





import com.example.newsletter.models.Article
import com.example.newsletter.models.ArticleResponse
import com.example.newsletter.models.EditeurResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitApiService {

    //GET --> On lance une requête de type GET
    // everything est l'action du web service qu'on veut apeler
    // Elle sera concaténée avec l'url prédéfini dans retrofit
    @GET("/everything")
    fun list(): Call<List<Article>>
    @GET("/v2/sources")
    fun editeur() : Call<EditeurResponse>
    @GET("/v2/top-headlines")
    fun source(@Query("sources") query: String): Call<ArticleResponse>
    @GET("/v2/top-headlines")
    fun category(@Query("category") query: String): Call<ArticleResponse>
    @GET("/v2/top-headlines")
    fun  country(@Query("country") query: String): Call<ArticleResponse>
}