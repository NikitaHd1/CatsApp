package com.example.testapp.domain.interactors

import com.example.testapp.data.repository.CatsRepository
import com.example.testapp.domain.Interactors
import com.example.testapp.domain.Mappers
import com.example.testapp.domain.models.CatModel
import com.example.testapp.domain.models.PaginationParams
import io.reactivex.Single
import javax.inject.Inject

class GetCatsInteractorImpl @Inject constructor(
    private val repository: CatsRepository,
    private val catsRequestMapper: Mappers.CatsRequestMapper,
    private val catsResponseMapper: Mappers.CatsResponseMapper
) : Interactors.GetCatsInteractor {

    override fun execute(parameters: PaginationParams): Single<List<CatModel>> =
        repository.getCats(catsRequestMapper.map(parameters)).map(catsResponseMapper::map)
}