package com.example.testapp.domain.mappers

import com.example.testapp.data.models.CatItemResponse
import com.example.testapp.domain.Mappers
import com.example.testapp.domain.models.CatModel
import javax.inject.Inject

class CatsResponseMapperImpl @Inject constructor() : Mappers.CatsResponseMapper {

    override fun map(item: CatItemResponse) =
        CatModel(item.id, item.url)

    override fun map(items: List<CatItemResponse>): List<CatModel> = when {
        items.isEmpty() -> listOf()
        else -> items
            .asSequence()
            .map(this::map)
            .toList()
    }
}