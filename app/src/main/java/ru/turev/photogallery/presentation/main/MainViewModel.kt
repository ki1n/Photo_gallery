package ru.turev.photogallery.presentation.main

import com.github.terrakok.cicerone.Router
import ru.turev.photogallery.navigation.Screens
import ru.turev.photogallery.presentation.base.BaseViewModel
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val router: Router
) : BaseViewModel() {

    fun onPhotoGalleryScreen() = router.newRootScreen(Screens.photoGalleryScreen())
}
