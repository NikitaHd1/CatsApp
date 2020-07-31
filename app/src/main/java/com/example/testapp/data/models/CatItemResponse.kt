package com.example.testapp.data.models

import com.google.gson.annotations.SerializedName

data class CatImageResponse(
    @SerializedName("breeds")
    val breeds: List<Breed>,
    @SerializedName("categories")
    val categories: List<Category>,
    @SerializedName("height")
    val height: Int,
    @SerializedName("id")
    val id: String,
    @SerializedName("url")
    val url: String,
    @SerializedName("width")
    val width: Int
)

data class Category(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String
)

data class Breed(
    @SerializedName("id")
    val id: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("temperament")
    val temperament: String,
    @SerializedName("wikipedia_url")
    val wikipediaUrl: String
)