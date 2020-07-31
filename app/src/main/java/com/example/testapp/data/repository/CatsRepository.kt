package com.example.testapp.data.repository

import com.example.testapp.data.models.CatsPaginationRequest
import com.example.testapp.domain.models.CatItem
import io.reactivex.Single

interface CatsRepository {

    fun getCats(params: CatsPaginationRequest): Single<List<CatItem>>
}