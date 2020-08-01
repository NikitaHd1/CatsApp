package com.example.testapp.presentation.catslist

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.testapp.R
import com.example.testapp.domain.models.CatItem
import com.example.testapp.presentation.adapters.CatsAdapter
import com.example.testapp.presentation.base.BaseFragment
import com.example.testapp.presentation.listeners.EndlessRecyclerViewScrollListener
import com.example.testapp.presentation.utils.FileUtil.saveImage
import kotlinx.android.synthetic.main.fragment_cats_list.*
import java.io.File
import javax.inject.Inject

class CatsListFragment : BaseFragment(R.layout.fragment_cats_list), CatsListMvp.CatListView {

    @Inject
    lateinit var presenter: CatsListMvp.CatListBasePresenter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.attachView(this)
        showFavoritesButton.setOnClickListener {
            findNavController().navigate(CatsListFragmentDirections.toFavoriteList())
        }
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        recyclerView.apply {
            hasFixedSize()
            adapter = CatsAdapter(
                onAddToFavoriteListener = { imageId: String, imageUrl: String ->
                    presenter.saveToFavoriteList(imageId, imageUrl)
                },
                onRemoveFromFavoriteListener = { imageId: String ->
                    presenter.removeItemFromFavoriteList(imageId)
                },
                saveImageListener = { imageFile, imageName, fileExtension ->
                    saveImageToFile(imageFile, imageName, fileExtension)
                })
            layoutManager = LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
            addOnScrollListener(object :
                EndlessRecyclerViewScrollListener(layoutManager as LinearLayoutManager) {
                override fun onLoadMore(page: Int, totalItemsCount: Int, view: RecyclerView) {
                    presenter.loadMore(page)
                }
            })
        }
    }

    private fun saveImageToFile(imageFile: File, imageName: String, fileExtension: String) {
        checkWritePermission {
            saveImage(imageFile, imageName, fileExtension)
        }
    }

    override fun updateData(catsList: List<CatItem>) {
        (recyclerView.adapter as CatsAdapter).update(catsList)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        presenter.detachView()
    }
}