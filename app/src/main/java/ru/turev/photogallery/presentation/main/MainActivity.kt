package ru.turev.photogallery.presentation.main

import android.os.Bundle
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.androidx.AppNavigator
import ru.turev.photogallery.R
import ru.turev.photogallery.databinding.ActivityMainBinding
import ru.turev.photogallery.navigation.Navigator
import ru.turev.photogallery.presentation.base.BaseActivity
import ru.turev.photogallery.presentation.base.binding.viewBinding
import javax.inject.Inject

class MainActivity : BaseActivity<MainViewModel>() {

    @Inject
    lateinit var navigatorHolder: NavigatorHolder

    private val binding by viewBinding(ActivityMainBinding::inflate)

    private val navigator : AppNavigator by lazy { Navigator(this, R.id.container) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        navigatorHolder.setNavigator(navigator)
        viewModel.onPhotoGalleryScreen()
    }

    override fun onPause() {
        navigatorHolder.removeNavigator()
        super.onPause()
    }
}
