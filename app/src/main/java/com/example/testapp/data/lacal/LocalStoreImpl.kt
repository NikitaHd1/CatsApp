package com.example.testapp.data.lacal

import com.example.testapp.data.room.FavoriteCats
import com.example.testapp.data.room.CatDao
import io.reactivex.Completable
import io.reactivex.Single
import javax.inject.Inject

class LocalStoreImpl @Inject constructor(
    private val catDao: CatDao
) : LocalStore {

    override fun deleteFavoriteCat(id: String) = Completable.create { emitter ->
        try {
            val result = catDao.delete(id)
            if (result > 0) {
                emitter.onComplete()
            } else {
                emitter.onError(NoSuchElementException())
            }
        } catch (e: Exception) {
            emitter.onError(e)
        }
    }

    override fun saveFavoriteCat(favoriteCats: FavoriteCats) = Completable.create { emitter ->
        try {
            val isSaved = catDao.insert(favoriteCats).none { it == 0L }
            if (isSaved) {
                emitter.onComplete()
            } else {
                emitter.onError(Exception())
            }
        } catch (e: Exception) {
            emitter.onError(e)
        }
    }

    override fun getAllFavoriteCats() = Single.create<List<FavoriteCats>> {
        try {
            it.onSuccess(catDao.getAllCats())
        } catch (e: Exception) {
            it.onError(e)
        }
    }
}