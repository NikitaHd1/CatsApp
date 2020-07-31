package com.example.testapp.presentation.catslist

import com.example.testapp.di.modules.BaseModule
import dagger.Module

@Module
class CatsListModule :
    BaseModule<CatsListFragment, CatsListMvp.CatListView, CatsListPresenterImpl, CatsListMvp.CatListBasePresenter>()