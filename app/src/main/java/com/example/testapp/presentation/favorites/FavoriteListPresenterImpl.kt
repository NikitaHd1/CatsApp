package com.example.testapp.presentation.favorites

import com.example.testapp.R
import com.example.testapp.domain.Interactors
import com.example.testapp.presentation.base.BasePresenter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class FavoriteListPresenterImpl @Inject constructor(
    private val getFavoriteCatsInteractor: Interactors.GetFavoriteCatsInteractor
) : BasePresenter<FavoriteListMvp.FavoriteListView>(), FavoriteListMvp.FavoriteBasePresenter {

    override fun attachView(view: FavoriteListMvp.FavoriteListView) {
        super.attachView(view)
        loadFavoriteCats()
    }

    private fun loadFavoriteCats() {
        addDisposable(
            getFavoriteCatsInteractor.execute(Unit)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    view?.showFavoriteCatsList(it)
                }, {
                    view?.showError(R.string.default_error_message)
                })
        )
    }
}

