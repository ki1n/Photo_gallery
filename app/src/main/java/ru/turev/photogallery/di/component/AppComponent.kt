package ru.turev.photogallery.di.component

import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import ru.turev.photogallery.AppPhotoGallery
import ru.turev.photogallery.di.module.ActivityModule
import ru.turev.photogallery.di.module.AppModule
import ru.turev.photogallery.di.module.FragmentModule
import ru.turev.photogallery.di.module.MappersModule
import ru.turev.photogallery.di.module.NavigationModule
import ru.turev.photogallery.di.module.NetworkModule
import ru.turev.photogallery.di.module.RepositoryModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        AndroidInjectionModule::class,
        AppModule::class,
        NavigationModule::class,
        NetworkModule::class,
        ActivityModule::class,
        FragmentModule::class,
        RepositoryModule::class,
        MappersModule::class,
//        InteractorModule::class,
    ]
)
interface AppComponent : AndroidInjector<AppPhotoGallery> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: AppPhotoGallery): Builder

        fun build(): AppComponent
    }
}
