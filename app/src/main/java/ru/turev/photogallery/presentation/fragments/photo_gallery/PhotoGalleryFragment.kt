package ru.turev.photogallery.presentation.fragments.photo_gallery

import android.os.Bundle
import android.view.View
import ru.turev.photogallery.R
import ru.turev.photogallery.databinding.PhotoGalleryFragmentBinding
import ru.turev.photogallery.presentation.base.BaseFragment
import ru.turev.photogallery.presentation.base.binding.viewBinding

class PhotoGalleryFragment : BaseFragment<PhotoGalleryViewModel>(R.layout.photo_gallery_fragment) {

    private val binding by viewBinding(PhotoGalleryFragmentBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }


    companion object {
        fun getInstance() = PhotoGalleryFragment()
    }
}
