package ru.turev.photogallery.presentation.fragments.photo_gallery.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import ru.turev.photogallery.databinding.ItemPhotoGalleryBinding
import ru.turev.photogallery.domain.entity.ItemPhoto
import ru.turev.photogallery.util.exstension.setOnDebouncedClickListener

class PhotoGalleryAdapter :
    ListAdapter<ItemPhoto, PhotoGalleryViewHolder>(PhotoGalleryDiffCallback()) {

    var onClickListener: ((ItemPhoto) -> Unit) = {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoGalleryViewHolder {
        val binding =
            ItemPhotoGalleryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PhotoGalleryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PhotoGalleryViewHolder, position: Int) {
        val currentPhoto = currentList[position]
        holder.bind(currentPhoto)
        holder.item.setOnDebouncedClickListener {
            onClickListener.invoke(currentPhoto)
        }
    }

    override fun getItemCount(): Int {
        return currentList.size
    }
}
