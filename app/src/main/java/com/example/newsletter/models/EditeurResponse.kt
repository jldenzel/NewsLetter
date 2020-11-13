package com.example.newsletter.models

import com.google.gson.annotations.SerializedName

data class EditeurResponse (
        val status: String,
        @SerializedName("sources")
        val editeur : List<Editeur>
)
