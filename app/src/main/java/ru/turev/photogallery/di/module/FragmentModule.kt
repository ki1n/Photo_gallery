package ru.turev.photogallery.di.module

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap
import ru.turev.photogallery.di.component.ViewModelKey
import ru.turev.photogallery.presentation.fragments.photogallery.PhotoGalleryFragment
import ru.turev.photogallery.presentation.fragments.photogallery.PhotoGalleryViewModel

@Module
interface FragmentModule {

    @ContributesAndroidInjector
    fun contributeFirstFragment(): PhotoGalleryFragment

    @Binds
    @IntoMap
    @ViewModelKey(PhotoGalleryViewModel::class)
    fun bindPhotoGalleryViewModel(viewModel: PhotoGalleryViewModel): ViewModel

}
