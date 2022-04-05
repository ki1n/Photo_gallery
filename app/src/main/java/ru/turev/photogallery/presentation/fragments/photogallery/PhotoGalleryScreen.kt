package ru.turev.photogallery.presentation.fragments.photogallery

import com.github.terrakok.cicerone.androidx.FragmentScreen

fun photoGalleryScreen() = FragmentScreen {
    PhotoGalleryFragment.getInstance()
}
