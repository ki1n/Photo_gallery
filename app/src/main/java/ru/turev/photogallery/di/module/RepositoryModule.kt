package ru.turev.photogallery.di.module

import dagger.Module
import dagger.Provides
import ru.turev.photogallery.data.network.api.ApiService
import ru.turev.photogallery.data.network.mapper.PhotoResponseMapper
import ru.turev.photogallery.data.network.repository.PhotoRepositoryImpl
import ru.turev.photogallery.domain.repository.PhotoRepository
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun provideAllPhotos(
        apiService: ApiService,
    ): PhotoRepository = PhotoRepositoryImpl(apiService)

}
