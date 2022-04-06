package ru.turev.photogallery.di.module

import dagger.Module
import dagger.Provides
import ru.turev.photogallery.data.network.mapper.PhotoResponseMapper
import ru.turev.photogallery.domain.interactor.PhotoInteractor
import ru.turev.photogallery.domain.repository.PhotoRepository
import javax.inject.Singleton

@Module
class InteractorModule {

    @Provides
    @Singleton
    fun providePhotoInteractor(
        photoRepository: PhotoRepository,
        photoResponseMapper: PhotoResponseMapper
    ) = PhotoInteractor(photoRepository, photoResponseMapper)

}
