package com.example.testapp.presentation.favorites

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.testapp.R
import com.example.testapp.domain.models.CatModel
import com.example.testapp.presentation.adapters.FavoriteCatsAdapter
import com.example.testapp.presentation.dialogs.FullscreenDialogFragment
import com.example.testapp.presentation.utils.ViewUtil.isVisible
import kotlinx.android.synthetic.main.fragment_favorities_list.*
import javax.inject.Inject

class FavoriteListFragment : FullscreenDialogFragment(R.layout.fragment_favorities_list),
    FavoriteListMvp.FavoriteListView {

    @Inject
    lateinit var presenter: FavoriteListMvp.FavoriteBasePresenter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        presenter.attachView(this)
        initToolBar()
    }

    override fun showFavoriteCatsList(cats: List<CatModel>) {
        emptyView.isVisible = false
        (recyclerView.adapter as FavoriteCatsAdapter).update(cats)
    }

    private fun setupRecyclerView() {
        recyclerView.apply {
            hasFixedSize()
            adapter = FavoriteCatsAdapter(mutableListOf())
            layoutManager = LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
        }
    }

    private fun initToolBar() {
        toolbar.setNavigationOnClickListener {
            activity?.onBackPressed()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        presenter.detachView()
    }
}