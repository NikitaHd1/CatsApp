package com.example.testapp.presentation.catslist

import com.example.testapp.presentation.base.IBaseView
import com.example.testapp.presentation.base.IBasePresenter
import com.example.testapp.presentation.model.CatItem

interface CatsListMvp {

    interface CatListBasePresenter : IBasePresenter<CatListView> {

        fun loadMore(page: Int)

        fun saveToFavoriteList(imageId: String, imageUrl: String)

        fun removeItemFromFavoriteList(imageId: String)
    }

    interface CatListView : IBaseView {

        fun updateData(catsList: List<CatItem>)
    }
}