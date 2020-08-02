package com.example.testapp.presentation.catslist

import com.example.testapp.R
import com.example.testapp.domain.Interactors
import com.example.testapp.domain.models.CatModel
import com.example.testapp.domain.models.PaginationParams
import com.example.testapp.presentation.base.BasePresenter
import com.example.testapp.presentation.model.CatItem
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.BiFunction
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class CatsListPresenterImpl @Inject constructor(
    private val getCatsInteractor: Interactors.GetCatsInteractor,
    private val deleteFavoriteCatInteractor: Interactors.DeleteFavoriteCatInteractor,
    private val saveToFavoriteCatsInteractor: Interactors.SaveToFavoriteCatsInteractor,
    private val getFavoriteCatsInteractor: Interactors.GetFavoriteCatsInteractor
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
        addDisposable(
            saveToFavoriteCatsInteractor.execute(CatModel(imageId, imageUrl))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    view?.showSuccessMessage(R.string.cat_saved_message)
                }, {
                    view?.showError(R.string.default_error_message)
                })
        )
    }

    override fun removeItemFromFavoriteList(imageId: String) {
        addDisposable(
            deleteFavoriteCatInteractor.execute(imageId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    view?.showSuccessMessage(R.string.cat_deleted_message)
                }, {
                    view?.showError(R.string.default_error_message)
                })
        )
    }

    private fun loadCats(page: String) {
        addDisposable(
            Single.zip(
                getCatsInteractor.execute(PaginationParams(LIMIT.toString(), page, ORDER)),
                getFavoriteCatsInteractor.execute(Unit),
                BiFunction<List<CatModel>, List<CatModel>, List<CatItem>> { catsResponse, favoriteCats ->
                    val catItems = mutableListOf<CatItem>()
                    catsResponse.forEach { cat ->
                        val isFavoriteCat = favoriteCats.any { it.id == cat.id }
                        catItems.add(CatItem(cat.id, cat.imageUrl, isFavoriteCat))
                    }
                    return@BiFunction catItems
                }
            )
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    it?.let { view?.updateData(it) }
                }, {
                    view?.showError(R.string.default_error_message)
                })
        )
    }
}