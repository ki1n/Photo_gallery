package ru.turev.photogallery.presentation.fragments.photo_gallery

import com.github.terrakok.cicerone.androidx.FragmentScreen

fun photoGalleryScreen() = FragmentScreen {
    PhotoGalleryFragment.getInstance()
}
