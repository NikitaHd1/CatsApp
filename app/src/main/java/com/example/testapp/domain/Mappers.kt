package com.example.testapp.domain

import com.example.testapp.data.room.FavoriteCats
import com.example.testapp.data.models.CatItemResponse
import com.example.testapp.data.models.CatsPaginationRequest
import com.example.testapp.domain.base.BaseMapper
import com.example.testapp.domain.models.CatModel
import com.example.testapp.domain.models.PaginationParams

interface Mappers {

    interface CatsResponseMapper : BaseMapper<CatItemResponse, CatModel>
    interface CatsRequestMapper : BaseMapper<PaginationParams, CatsPaginationRequest>
    interface FavoriteCatsMapper : BaseMapper<FavoriteCats, CatModel>
    interface CatModelMapper : BaseMapper<CatModel, FavoriteCats>
}