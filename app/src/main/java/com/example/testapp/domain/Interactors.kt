package com.example.testapp.domain

import com.example.testapp.domain.base.BaseInteractor
import com.example.testapp.domain.models.CatModel
import com.example.testapp.domain.models.PaginationParams
import io.reactivex.Completable
import io.reactivex.Single

interface Interactors {

    interface GetCatsInteractor : BaseInteractor<PaginationParams, Single<List<CatModel>>>

    interface GetFavoriteCatsInteractor : BaseInteractor<Unit, Single<List<CatModel>>>

    interface SaveToFavoriteCatsInteractor : BaseInteractor<CatModel, Completable>

    interface DeleteFavoriteCatInteractor : BaseInteractor<String, Completable>
}