package ru.turev.photogallery.presentation.fragments.photo_gallery.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import ru.turev.photogallery.databinding.ItemPhotoGalleryBinding
import ru.turev.photogallery.domain.entity.ItemPhoto

class PhotoGalleryAdapter :
    ListAdapter<ItemPhoto, PhotoGalleryViewHolder>(PhotoGalleryDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoGalleryViewHolder {
        val binding =
            ItemPhotoGalleryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PhotoGalleryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PhotoGalleryViewHolder, position: Int) {
        val currentPhoto = currentList[position]
        holder.bind(currentPhoto)
    }

    override fun getItemCount(): Int {
        return currentList.size
    }
}
