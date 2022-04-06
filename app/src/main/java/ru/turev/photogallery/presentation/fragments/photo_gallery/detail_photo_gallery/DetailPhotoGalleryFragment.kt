package ru.turev.photogallery.presentation.fragments.photo_gallery.detail_photo_gallery

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import com.bumptech.glide.Glide
import ru.turev.photogallery.R
import ru.turev.photogallery.databinding.DetailPhotoGalleryFragmentBinding
import ru.turev.photogallery.domain.entity.ItemPhoto
import ru.turev.photogallery.presentation.base.BaseFragment
import ru.turev.photogallery.presentation.base.binding.viewBinding
import ru.turev.photogallery.util.exstension.setOnDebouncedClickListener

class DetailPhotoGalleryFragment :
    BaseFragment<DetailPhotoGalleryViewModel>(R.layout.detail_photo_gallery_fragment) {

    private val binding by viewBinding(DetailPhotoGalleryFragmentBinding::bind)

    private val itemPhoto by lazy {
        requireArguments().getParcelable<ItemPhoto>(ARGUMENT_PAYLOAD)!!
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initData()
    }

    private fun initData() {
        with(binding) {
            Glide.with(imageFull.context)
                .load(itemPhoto.full)
                .into(imageFull)

            appBarPhotoGallerySearch.tvName.text = itemPhoto.name

            appBarPhotoGallerySearch.imgBack.setOnDebouncedClickListener {
                viewModel.onCloseClicked()
            }
        }
    }

    companion object {
        private const val ARGUMENT_PAYLOAD = "payload"

        fun getInstance(itemPhoto: ItemPhoto) = DetailPhotoGalleryFragment().apply {
            arguments = bundleOf(ARGUMENT_PAYLOAD to itemPhoto)
        }
    }
}
