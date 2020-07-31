package com.example.testapp.presentation.favorites

import android.os.Bundle
import android.view.View
import com.example.testapp.R
import com.example.testapp.presentation.base.BaseActivity
import com.example.testapp.presentation.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_favorities_list.*
import javax.inject.Inject

class FavoriteListFragment : BaseFragment(R.layout.fragment_favorities_list),
    FavoriteListMvp.FavoriteListView {

    @Inject
    lateinit var presenter: FavoriteListMvp.FavoriteBasePresenter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.attachView(this)
        button.setOnClickListener {
            (activity as BaseActivity?)?.onBackPressed()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        presenter.detachView()
    }
}