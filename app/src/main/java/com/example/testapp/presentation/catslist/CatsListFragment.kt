package com.example.testapp.presentation.catslist

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.example.testapp.R
import com.example.testapp.presentation.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_cats_list.*
import javax.inject.Inject

class CatsListFragment : BaseFragment(R.layout.fragment_cats_list), CatsListMvp.CatListView {

    @Inject
    lateinit var presenter: CatsListMvp.CatListBasePresenter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.attachView(this)
        button.setOnClickListener {
            findNavController().navigate(CatsListFragmentDirections.toFavoriteList())
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        presenter.detachView()
    }
}