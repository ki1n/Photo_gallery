package ru.turev.photogallery.presentation.fragments.photo_gallery

import android.os.Bundle
import android.view.View
import androidx.core.widget.doAfterTextChanged
import ru.turev.photogallery.R
import ru.turev.photogallery.databinding.PhotoGalleryFragmentBinding
import ru.turev.photogallery.domain.enums.State
import ru.turev.photogallery.presentation.base.BaseFragment
import ru.turev.photogallery.presentation.base.binding.viewBinding
import ru.turev.photogallery.presentation.fragments.photo_gallery.adapter.PhotoGalleryAdapter

class PhotoGalleryFragment : BaseFragment<PhotoGalleryViewModel>(R.layout.photo_gallery_fragment) {

    private val binding by viewBinding(PhotoGalleryFragmentBinding::bind)

    private val photoAdapter by lazy { PhotoGalleryAdapter() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()
        with(binding) {
            viewModel.stateLiveData.observe(viewLifecycleOwner, ::handleState)

            appBarPhotoGallerySearch.etSearch.doAfterTextChanged { searchInput ->
                viewModel.onSearchInputUpdate(searchInput.toString())
            }

            appBarPhotoGallerySearch.imgSearch.setOnClickListener {
                viewModel.onSearch()
            }

            appBarPhotoGallerySearch.imgClear.setOnClickListener {
                viewModel.onClear()
                appBarPhotoGallerySearch.etSearch.setText("")
            }
        }
    }

    private fun handleState(state: PhotoGalleryView.Model) {
        with(binding) {
            photoAdapter.submitList(state.items)
            if (state.searchInputEmpty) {
                appBarPhotoGallerySearch.imgClear.visibility = View.VISIBLE
                appBarPhotoGallerySearch.imgSearch.visibility = View.INVISIBLE
            } else {
                appBarPhotoGallerySearch.imgClear.visibility = View.INVISIBLE
                appBarPhotoGallerySearch.imgSearch.visibility = View.VISIBLE
            }

            if (state.items.isEmpty() && state.error == State.COMPLETE) {
                appBarPhotoGalleryNull.root.visibility = View.VISIBLE
            } else {
                appBarPhotoGalleryNull.root.visibility = View.INVISIBLE
            }

            if (state.error == State.ERROR && state.items.isEmpty()) {
                appBarPhotoGalleryError.root.visibility = View.VISIBLE
            } else {
                appBarPhotoGalleryError.root.visibility = View.INVISIBLE
            }
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
