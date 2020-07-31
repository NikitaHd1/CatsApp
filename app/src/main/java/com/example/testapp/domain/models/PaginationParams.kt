package com.example.testapp.domain.models

data class PaginationParams(
    val limit: String,
    val page: String,
    val order: String
)