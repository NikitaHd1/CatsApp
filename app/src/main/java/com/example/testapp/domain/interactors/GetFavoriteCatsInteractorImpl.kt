package com.example.testapp.domain.interactors

import com.example.testapp.data.repository.CatsRepository
import com.example.testapp.domain.Interactors
import javax.inject.Inject

class GetFavoriteCatsInteractorImpl @Inject constructor(
    private val repository: CatsRepository
) : Interactors.GetFavoriteCatsInteractor {

    override fun execute(parameters: Unit) = repository.getAllFavoriteCats()
}