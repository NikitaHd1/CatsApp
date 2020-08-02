package com.example.testapp.data.network

import com.example.testapp.data.models.CatItemResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("images/search")
    fun getCats(
        @Query("limit") limit: String,
        @Query("page") page: String,
        @Query("order") order: String
    ): Single<List<CatItemResponse>>
}