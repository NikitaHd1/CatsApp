package com.example.testapp.domain.mappers

import com.example.testapp.data.room.FavoriteCats
import com.example.testapp.domain.Mappers
import com.example.testapp.domain.models.CatModel
import javax.inject.Inject

class CatModelMapperImpl @Inject constructor() : Mappers.CatModelMapper {

    override fun map(item: CatModel) = FavoriteCats(item.id, item.imageUrl)

    override fun map(items: List<CatModel>): List<FavoriteCats> = when {
        items.isEmpty() -> listOf()
        else -> items
            .asSequence()
            .map(this::map)
            .toList()
    }
}