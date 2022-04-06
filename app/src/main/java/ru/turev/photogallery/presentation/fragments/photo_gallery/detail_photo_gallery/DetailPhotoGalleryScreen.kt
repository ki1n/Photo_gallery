package ru.turev.photogallery.presentation.fragments.photo_gallery.detail_photo_gallery

import com.github.terrakok.cicerone.androidx.FragmentScreen
import ru.turev.photogallery.domain.entity.ItemPhoto

fun detailPhotoGalleryScreen(itemPhoto: ItemPhoto) = FragmentScreen {
    DetailPhotoGalleryFragment.getInstance(itemPhoto)
}
