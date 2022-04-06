package ru.turev.photogallery.presentation.fragments.photo_gallery

import ru.turev.photogallery.data.network.api.response.PhotoResponse
import ru.turev.photogallery.domain.entity.ItemPhoto
import ru.turev.photogallery.domain.enums.State

interface PhotoGalleryView {

    data class Model(
        val items: List<PhotoResponse> = emptyList(),
        val error: State = State.LOADING,
    )
}
