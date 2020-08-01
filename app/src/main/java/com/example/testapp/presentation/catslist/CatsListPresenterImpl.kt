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

    companion object {
        const val LIMIT = 20
        private const val ORDER = "DESC"
        private const val FIRST_PAGE = "0"
    }

    override fun attachView(view: CatsListMvp.CatListView) {
        super.attachView(view)
        loadCats(FIRST_PAGE)
    }

    override fun loadMore(page: Int) {
        loadCats(page.toString())
    }

    override fun saveToFavoriteList(imageId: String, imageUrl: String) {

    }

    override fun removeItemFromFavoriteList(imageId: String) {

    }

    private fun loadCats(page: String) {
        addDisposable(
            getCatsInteractor.execute(PaginationParams(LIMIT.toString(), page, ORDER))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    it?.let { view?.updateData(it) }
                }, {

                })
        )
    }
}