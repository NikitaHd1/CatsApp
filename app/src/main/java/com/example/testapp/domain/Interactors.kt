package com.example.testapp.domain

import com.example.testapp.domain.base.BaseInteractor
import com.example.testapp.domain.models.CatItem
import com.example.testapp.domain.models.PaginationParams
import io.reactivex.Single

interface Interactors {

    interface GetCatsInteractor : BaseInteractor<PaginationParams, Single<List<CatItem>>>
}