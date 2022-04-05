package ru.turev.photogallery.presentation.main

import com.github.terrakok.cicerone.Router
import ru.turev.photogallery.presentation.base.BaseViewModel
import ru.turev.photogallery.presentation.fragments.photo_gallery.photoGalleryScreen
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val router: Router
) : BaseViewModel() {

    fun onPhotoGalleryScreen() = router.newRootScreen(photoGalleryScreen())
}
