package com.example.testapp.presentation.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.testapp.R
import com.example.testapp.domain.models.CatModel
import com.example.testapp.presentation.utils.ViewUtil
import com.example.testapp.presentation.utils.ViewUtil.loadImage
import kotlinx.android.synthetic.main.favorite_cat_item.view.*

class FavoriteCatsAdapter(var favoriteCatsList: MutableList<CatModel>) :
    RecyclerView.Adapter<FavoriteCatsAdapter.FavoriteCatsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteCatsViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.favorite_cat_item, parent, false)
        return FavoriteCatsViewHolder(view)
    }

    override fun getItemCount() = favoriteCatsList.size

    override fun onBindViewHolder(holder: FavoriteCatsViewHolder, position: Int) {
        holder.bind(favoriteCatsList[position])
    }

    fun update(favoriteCats: List<CatModel>) {
        favoriteCatsList.clear()
        favoriteCatsList.addAll(favoriteCats)
        notifyDataSetChanged()
    }

    inner class FavoriteCatsViewHolder(private val view: View) :
        RecyclerView.ViewHolder(view) {

        private val progressDrawable = ViewUtil.getProgressDrawable(view.context)

        fun bind(catModel: CatModel) {
            view.description.text = view.context.getString(R.string.image_id, catModel.id)
            view.imageView.loadImage(catModel.imageUrl, progressDrawable) {}
        }
    }
}