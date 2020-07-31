package com.example.testapp.data.models

data class CatsPaginationRequest(
    val limit: String,
    val page: String,
    val order: String
)