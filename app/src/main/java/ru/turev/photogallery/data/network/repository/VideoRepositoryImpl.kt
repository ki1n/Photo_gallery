package ru.turev.photogallery.data.network.repository

import io.reactivex.Single
import ru.turev.photogallery.data.network.api.ApiService
import ru.turev.photogallery.data.network.mapper.PhotoResponseMapper
import ru.turev.photogallery.domain.entity.ItemPhoto
import ru.turev.photogallery.domain.repository.PhotoRepository
import ru.turev.photogallery.util.exstension.toSingle

class PhotoRepositoryImpl(
    private val apiService: ApiService,
    private val photoResponseMapper: PhotoResponseMapper
) : PhotoRepository {

    override fun getAllPhotos(page: Int, perPage: Int): Single<List<ItemPhoto>> =
        apiService.getAllPhotos(page, perPage)
            .flatMap {
                photoResponseMapper.mapToDomain(it).toSingle()
            }
}
