package ru.turev.photogallery

import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import ru.turev.photogallery.di.component.DaggerAppComponent
import timber.log.Timber

class AppPhotoGallery : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> =
        DaggerAppComponent.builder().application(this).build()

    override fun onCreate() {
        super.onCreate()
        initTimber()
    }

    private fun initTimber() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}
