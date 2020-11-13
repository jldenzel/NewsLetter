package com.example.newsletter.models

data class Article (
    val title: String,
    val description: String,
    val content: String,
    val author:String,
    val publish: String,
    val urlImage: String,
    var favoritebut: Int =0
    )