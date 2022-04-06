package ru.turev.photogallery.domain.repository

import io.reactivex.Single
import retrofit2.http.Query
import ru.turev.photogallery.data.network.api.response.PhotoResponse
import ru.turev.photogallery.domain.entity.ItemPhoto

interface PhotoRepository {

    fun getAllPhotos(page: Int, perPage: Int): Single<List<ItemPhoto>>

    fun getSearchPhotos(query: String, perPage: Int) : Single<List<ItemPhoto>>
}
