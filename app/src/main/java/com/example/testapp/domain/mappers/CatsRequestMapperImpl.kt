package com.example.testapp.domain.mappers

import com.example.testapp.data.models.CatsPaginationRequest
import com.example.testapp.domain.Mappers
import com.example.testapp.domain.models.PaginationParams
import javax.inject.Inject

class CatsRequestMapperImpl @Inject constructor() : Mappers.CatsRequestMapper {

    override fun map(item: PaginationParams) = CatsPaginationRequest(
        item.limit,
        item.page,
        item.order
    )

    override fun map(items: List<PaginationParams>): List<CatsPaginationRequest> = when {
        items.isEmpty() -> listOf()
        else -> items
            .asSequence()
            .map(this::map)
            .toList()
    }
}