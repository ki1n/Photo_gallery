package ru.turev.photogallery.presentation.fragments.photo_gallery

import ru.turev.photogallery.domain.entity.ItemPhoto
import ru.turev.photogallery.domain.enums.State
import ru.turev.photogallery.util.exstension.empty

interface PhotoGalleryView {

    data class Model(
        val searchInput: String = String.empty,
        val searchInputEmpty: Boolean = true,
        val items: List<ItemPhoto> = emptyList(),
        val error: State = State.LOADING,
    )
}
