package com.example.testapp.domain.interactors

import com.example.testapp.data.repository.CatsRepository
import com.example.testapp.domain.Interactors
import io.reactivex.Completable
import javax.inject.Inject

class DeleteFavoriteCatInteractorImpl @Inject constructor(
    private val repository: CatsRepository
) : Interactors.DeleteFavoriteCatInteractor {

    override fun execute(parameters: String): Completable {
        return repository.deleteFavoriteCat(parameters)
    }
}