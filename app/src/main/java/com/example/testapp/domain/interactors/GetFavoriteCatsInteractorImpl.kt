package com.example.testapp.domain.interactors

import com.example.testapp.data.repository.CatsRepository
import com.example.testapp.domain.Interactors
import com.example.testapp.domain.Mappers
import javax.inject.Inject

class GetFavoriteCatsInteractorImpl @Inject constructor(
    private val repository: CatsRepository,
    private val mapper: Mappers.FavoriteCatsMapper
) : Interactors.GetFavoriteCatsInteractor {

    override fun execute(parameters: Unit) = repository.getAllFavoriteCats().map(mapper::map)
}