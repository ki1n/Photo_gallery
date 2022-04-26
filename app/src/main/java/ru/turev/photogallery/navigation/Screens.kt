package ru.turev.photogallery.navigation

import com.github.terrakok.cicerone.androidx.FragmentScreen
import ru.turev.photogallery.domain.entity.ItemPhoto
import ru.turev.photogallery.presentation.fragments.photo_gallery.PhotoGalleryFragment
import ru.turev.photogallery.presentation.fragments.photo_gallery.detail_photo_gallery.DetailPhotoGalleryFragment

object Screens {

    fun detailPhotoGalleryScreen(itemPhoto: ItemPhoto) : FragmentScreen = FragmentScreen {
        DetailPhotoGalleryFragment.getInstance(itemPhoto)
    }

    fun photoGalleryScreen() : FragmentScreen = FragmentScreen {
        PhotoGalleryFragment.getInstance()
    }

}
