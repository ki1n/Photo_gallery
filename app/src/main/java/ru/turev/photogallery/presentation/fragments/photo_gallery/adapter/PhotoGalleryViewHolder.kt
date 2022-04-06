package ru.turev.photogallery.presentation.fragments.photo_gallery.adapter

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import ru.turev.photogallery.databinding.ItemPhotoGalleryBinding
import ru.turev.photogallery.domain.entity.ItemPhoto

class PhotoGalleryViewHolder(
    private val binding: ItemPhotoGalleryBinding,
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(itemPhoto: ItemPhoto) {
        with(binding) {
            Glide.with(imgItemPhotoGallery.context)
                .load(itemPhoto.regular)
                .into(imgItemPhotoGallery)

            imgInput.text = itemPhoto.name

        }
    }
}
