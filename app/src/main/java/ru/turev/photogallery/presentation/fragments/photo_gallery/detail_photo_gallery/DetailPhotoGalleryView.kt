package ru.turev.photogallery.presentation.fragments.photo_gallery.detail_photo_gallery

import ru.turev.photogallery.domain.enums.State
import ru.turev.photogallery.util.exstension.empty

interface DetailPhotoGalleryView {

    data class Model(
        val url: String = String.empty,
        val name: String = String.empty,
        val error: State = State.LOADING,
    )
}
