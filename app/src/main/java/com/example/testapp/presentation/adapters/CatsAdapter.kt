package com.example.testapp.presentation.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.testapp.R
import com.example.testapp.presentation.model.CatItem
import com.example.testapp.presentation.utils.ViewUtil.getCachedImageFile
import com.example.testapp.presentation.utils.ViewUtil.getProgressDrawable
import com.example.testapp.presentation.utils.ViewUtil.isVisible
import com.example.testapp.presentation.utils.ViewUtil.loadImage
import kotlinx.android.synthetic.main.cat_item.view.*
import java.io.File

class CatsAdapter(
    private val onAddToFavoriteListener: (String, String) -> Unit,
    private val onRemoveFromFavoriteListener: (String) -> Unit,
    private val saveImageListener: (File, String, String) -> Unit
) : RecyclerView.Adapter<CatsAdapter.CatsViewHolder>() {

    private var catsList = mutableListOf<CatItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatsViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.cat_item, parent, false)
        return CatsViewHolder(view)
    }

    override fun getItemCount() = catsList.size

    override fun onBindViewHolder(holder: CatsViewHolder, position: Int) {
        holder.bind(catsList[position])
    }

    fun update(catItems: List<CatItem>) {
        val oldSize = catsList.size
        catsList.addAll(catItems)
        notifyItemRangeInserted(oldSize, catsList.size)
    }

    inner class CatsViewHolder(private val view: View) :
        RecyclerView.ViewHolder(view) {

        private val progressDrawable = getProgressDrawable(view.context)

        fun bind(catItem: CatItem) {
            view.saveImageButton.isVisible = false
            loadImage(catItem)
            view.favoriteButton.setOnCheckedChangeListener(null)
            view.favoriteButton.isChecked = catItem.isFavorite
            setupListenerToFavoriteButton(catItem)
        }

        private fun setupListenerToFavoriteButton(catItem: CatItem) {
            view.favoriteButton.setOnCheckedChangeListener { _, isChecked ->
                if (isChecked) {
                    onAddToFavoriteListener(catItem.id, catItem.imageUrl)
                } else {
                    onRemoveFromFavoriteListener(catItem.id)
                }
                catItem.isFavorite = isChecked
            }
        }

        private fun loadImage(catItem: CatItem) {
            view.imageView.loadImage(catItem.imageUrl, progressDrawable) {
                view.saveImageButton.isVisible = true
                view.saveImageButton.setOnClickListener {
                    getCachedImageFile(
                        view.imageView.context,
                        catItem.imageUrl
                    ) { file, fileExtension ->
                        saveImageListener(file, catItem.id, fileExtension)
                    }
                }
            }
        }
    }
}