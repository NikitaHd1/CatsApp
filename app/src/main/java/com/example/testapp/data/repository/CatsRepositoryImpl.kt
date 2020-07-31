package com.example.testapp.data.repository

import com.example.testapp.data.models.CatsPaginationRequest
import com.example.testapp.data.network.ApiService
import com.example.testapp.domain.Mappers
import com.example.testapp.domain.models.CatItem
import io.reactivex.Single
import javax.inject.Inject

class CatsRepositoryImpl @Inject constructor(
    private val apiService: ApiService,
    private val catsResponseMapper: Mappers.CatsResponseMapper
) : CatsRepository {

    override fun getCats(params: CatsPaginationRequest): Single<List<CatItem>> =
        apiService.getCats(params.limit, params.page, params.order)
            .map(catsResponseMapper::map)
}