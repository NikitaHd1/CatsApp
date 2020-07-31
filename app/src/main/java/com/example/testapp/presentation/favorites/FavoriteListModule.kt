package com.example.testapp.presentation.favorites

import com.example.testapp.di.modules.BaseModule
import dagger.Module

@Module
class FavoriteListModule :
    BaseModule<FavoriteListFragment, FavoriteListMvp.FavoriteListView, FavoriteListPresenterImpl, FavoriteListMvp.FavoriteBasePresenter>()