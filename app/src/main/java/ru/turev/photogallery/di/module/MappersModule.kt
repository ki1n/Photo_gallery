package ru.turev.photogallery.di.module

import dagger.Module
import dagger.Provides
import ru.turev.photogallery.data.network.mapper.PhotoResponseMapper
import javax.inject.Singleton

@Module
class MappersModule {

    @Singleton
    @Provides
    fun providePhotoResponseMapper() = PhotoResponseMapper()
}
