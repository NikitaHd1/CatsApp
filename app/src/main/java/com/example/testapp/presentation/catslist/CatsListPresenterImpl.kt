package com.example.testapp.presentation.catslist

import com.example.testapp.domain.Interactors
import com.example.testapp.domain.models.PaginationParams
import com.example.testapp.presentation.base.BasePresenter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class CatsListPresenterImpl @Inject constructor(
    private val getCatsInteractor: Interactors.GetCatsInteractor
) : BasePresenter<CatsListMvp.CatListView>(),
    CatsListMvp.CatListBasePresenter {

    private val limit = 20
    private var page = 0
    private val order = "DESC"

    override fun attachView(view: CatsListMvp.CatListView) {
        super.attachView(view)
        addDisposable(
            getCatsInteractor.execute(PaginationParams(limit.toString(), page.toString(), order))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    if (it != null) {

                    }
                }, {

                })
        )
    }
}