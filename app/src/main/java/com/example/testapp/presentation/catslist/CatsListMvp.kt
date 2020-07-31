package com.example.testapp.presentation.catslist

import com.example.testapp.presentation.base.IBaseView
import com.example.testapp.presentation.base.IBasePresenter

interface CatsListMvp {

    interface CatListBasePresenter : IBasePresenter<CatListView>

    interface CatListView : IBaseView
}