package com.example.testapp.presentation.favorites

import com.example.testapp.presentation.base.BasePresenter
import javax.inject.Inject

class FavoriteListPresenterImpl @Inject constructor() :
    BasePresenter<FavoriteListMvp.FavoriteListView>(), FavoriteListMvp.FavoriteBasePresenter