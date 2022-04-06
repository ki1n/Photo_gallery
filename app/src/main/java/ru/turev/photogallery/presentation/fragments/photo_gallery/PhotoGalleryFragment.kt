package ru.turev.photogallery.presentation.fragments.photo_gallery

import android.os.Bundle
import android.view.View
import ru.turev.photogallery.R
import ru.turev.photogallery.databinding.PhotoGalleryFragmentBinding
import ru.turev.photogallery.presentation.base.BaseFragment
import ru.turev.photogallery.presentation.base.binding.viewBinding
import ru.turev.photogallery.presentation.fragments.photo_gallery.adapter.PhotoGalleryAdapter

class PhotoGalleryFragment : BaseFragment<PhotoGalleryViewModel>(R.layout.photo_gallery_fragment) {

    private val binding by viewBinding(PhotoGalleryFragmentBinding::bind)

    private val photoAdapter by lazy { PhotoGalleryAdapter() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()
        viewModel.stateLiveData.observe(viewLifecycleOwner, ::handleState)
    }

    private fun handleState(state: PhotoGalleryView.Model) {
        with(binding) {
            // todo тут проверка на ошибки
            photoAdapter.submitList(state.items)
        }
    }

    private fun initAdapter() {
        binding.rvPhotos.adapter = photoAdapter
        photoAdapter.onClickListener = {
            viewModel.onDetailPhotoGalleryScreen(it)
        }
    }

    companion object {
        fun getInstance() = PhotoGalleryFragment()
    }
}
