package com.example.testapp.presentation.favorites

import com.example.testapp.presentation.base.IBasePresenter
import com.example.testapp.presentation.base.IBaseView

interface FavoriteListMvp {

    interface FavoriteBasePresenter : IBasePresenter<FavoriteListView>

    interface FavoriteListView : IBaseView
}