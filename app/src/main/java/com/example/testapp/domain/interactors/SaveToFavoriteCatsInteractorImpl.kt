package com.example.testapp.domain.interactors

import com.example.testapp.data.repository.CatsRepository
import com.example.testapp.domain.Interactors
import com.example.testapp.domain.Mappers
import com.example.testapp.domain.models.CatModel
import io.reactivex.Completable
import javax.inject.Inject

class SaveToFavoriteCatsInteractorImpl @Inject constructor(
    private val repository: CatsRepository,
    private val catModelMapper: Mappers.CatModelMapper
) : Interactors.SaveToFavoriteCatsInteractor {

    override fun execute(parameters: CatModel): Completable {
        return repository.saveFavoriteCat(catModelMapper.map(parameters))
    }
}