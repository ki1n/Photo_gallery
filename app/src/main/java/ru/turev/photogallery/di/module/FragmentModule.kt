package ru.turev.photogallery.di.module

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap
import ru.turev.photogallery.di.component.ViewModelKey
import ru.turev.photogallery.presentation.fragments.photo_gallery.PhotoGalleryFragment
import ru.turev.photogallery.presentation.fragments.photo_gallery.PhotoGalleryViewModel
import ru.turev.photogallery.presentation.fragments.photo_gallery.detail_photo_gallery.DetailPhotoGalleryFragment
import ru.turev.photogallery.presentation.fragments.photo_gallery.detail_photo_gallery.DetailPhotoGalleryViewModel

@Module
interface FragmentModule {

    @ContributesAndroidInjector
    fun contributePhotoGalleryFragment(): PhotoGalleryFragment

    @Binds
    @IntoMap
    @ViewModelKey(PhotoGalleryViewModel::class)
    fun bindPhotoGalleryViewModel(viewModel: PhotoGalleryViewModel): ViewModel

    @ContributesAndroidInjector
    fun contributeDetailPhotoGalleryFragment(): DetailPhotoGalleryFragment

    @Binds
    @IntoMap
    @ViewModelKey(DetailPhotoGalleryViewModel::class)
    fun bindDetailPhotoGalleryViewModel(viewModel: DetailPhotoGalleryViewModel): ViewModel
}
