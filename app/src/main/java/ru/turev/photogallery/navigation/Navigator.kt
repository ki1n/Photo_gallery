package ru.turev.photogallery.navigation

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentTransaction
import com.github.terrakok.cicerone.androidx.AppNavigator
import com.github.terrakok.cicerone.androidx.FragmentScreen
import ru.turev.photogallery.R
import ru.turev.photogallery.presentation.fragments.photo_gallery.PhotoGalleryFragment
import ru.turev.photogallery.presentation.fragments.photo_gallery.detail_photo_gallery.DetailPhotoGalleryFragment

class Navigator(activity: FragmentActivity, containerId: Int) : AppNavigator(activity, containerId) {

    override fun setupFragmentTransaction(
        screen: FragmentScreen,
        fragmentTransaction: FragmentTransaction,
        currentFragment: Fragment?,
        nextFragment: Fragment
    ) {
        val enter = when {
            currentFragment == null && nextFragment is PhotoGalleryFragment -> 0
            nextFragment is DetailPhotoGalleryFragment -> R.anim.fade_in
            else -> R.anim.slide_in_right
        }
        val exit = when (nextFragment) {
            is PhotoGalleryFragment -> R.anim.slide_in_right
            is DetailPhotoGalleryFragment -> R.anim.slide_in_left
            else -> R.anim.slide_in_left
        }
        val popEnter = when (nextFragment) {
            is DetailPhotoGalleryFragment -> R.anim.idle
            else -> R.anim.slide_in_left
        }
        val popExit = when (nextFragment) {
            is DetailPhotoGalleryFragment -> R.anim.slide_in_left
            else -> R.anim.slide_out_right
        }
        fragmentTransaction.setCustomAnimations(enter, exit, popEnter, popExit)
    }
}
