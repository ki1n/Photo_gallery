package ru.turev.photogallery.di.module

import dagger.Module
import dagger.Provides
import ru.turev.photogallery.AppPhotoGallery
import javax.inject.Singleton

@Module
class AppModule() {

    @Provides
    @Singleton
    fun provideContext(application: AppPhotoGallery) = application.applicationContext!!
}
