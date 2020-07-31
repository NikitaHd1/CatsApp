package com.example.testapp.domain

import com.example.testapp.data.models.CatImageResponse
import com.example.testapp.data.models.CatsPaginationRequest
import com.example.testapp.domain.base.BaseMapper
import com.example.testapp.domain.models.CatItem
import com.example.testapp.domain.models.PaginationParams

interface Mappers {

    interface CatsResponseMapper : BaseMapper<CatImageResponse, CatItem>
    interface CatsRequestMapper : BaseMapper<PaginationParams, CatsPaginationRequest>
}