package com.example.testapp.domain.mappers

import com.example.testapp.data.models.CatImageResponse
import com.example.testapp.domain.Mappers
import com.example.testapp.domain.models.CatItem
import javax.inject.Inject

class CatsResponseMapperImpl @Inject constructor() : Mappers.CatsResponseMapper {

    override fun map(item: CatImageResponse) =
        CatItem(item.id, item.url)

    override fun map(items: List<CatImageResponse>): List<CatItem> = when {
        items.isEmpty() -> listOf()
        else -> items
            .asSequence()
            .map(this::map)
            .toList()
    }
}