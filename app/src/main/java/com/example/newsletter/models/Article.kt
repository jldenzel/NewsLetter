package com.example.newsletter.models


data class Article (
    val title: String,
    val source: Source,
    val description: String,
    val content: String,
    val author:String,
    val publishedAt: String,
    val urlToImage: String,
    var favoritebut: Int =0,
    val url: String
    )