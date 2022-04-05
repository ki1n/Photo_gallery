package ru.turev.photogallery.di.module

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap
import ru.turev.photogallery.di.component.ViewModelKey
import ru.turev.photogallery.presentation.main.MainActivity
import ru.turev.photogallery.presentation.main.MainViewModel

@Module(includes = [FragmentModule::class])
interface ActivityModule {

    @ContributesAndroidInjector()
    fun bindMainActivity(): MainActivity

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    fun bindMainViewModel(viewModel: MainViewModel): ViewModel
}
