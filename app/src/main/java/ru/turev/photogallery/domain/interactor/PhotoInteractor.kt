package ru.turev.photogallery.domain.interactor

import ru.turev.photogallery.data.network.mapper.PhotoResponseMapper
import ru.turev.photogallery.domain.repository.PhotoRepository

class PhotoInteractor(
    private val photoRepository: PhotoRepository,
    private val photoResponseMapper: PhotoResponseMapper
) {
}
