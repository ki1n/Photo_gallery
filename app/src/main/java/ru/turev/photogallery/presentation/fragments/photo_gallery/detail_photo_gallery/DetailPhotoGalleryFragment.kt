package ru.turev.photogallery.presentation.fragments.photo_gallery.detail_photo_gallery

import android.os.Bundle
import android.view.View
import ru.turev.photogallery.R
import ru.turev.photogallery.databinding.DetailPhotoGalleryFragmentBinding
import ru.turev.photogallery.presentation.base.BaseFragment
import ru.turev.photogallery.presentation.base.binding.viewBinding

class DetailPhotoGalleryFragment :
    BaseFragment<DetailPhotoGalleryViewModel>(R.layout.detail_photo_gallery_fragment) {

    private val binding by viewBinding(DetailPhotoGalleryFragmentBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    companion object {
        fun getInstance() = DetailPhotoGalleryFragment()
    }
}
