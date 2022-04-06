package ru.turev.photogallery.presentation.fragments.photo_gallery.adapter

import androidx.recyclerview.widget.DiffUtil
import ru.turev.photogallery.domain.entity.ItemPhoto

class PhotoGalleryDiffCallback : DiffUtil.ItemCallback<ItemPhoto>() {

    override fun areItemsTheSame(oldItem: ItemPhoto, newItem: ItemPhoto): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: ItemPhoto, newItem: ItemPhoto): Boolean {
        return oldItem == newItem
    }
}
