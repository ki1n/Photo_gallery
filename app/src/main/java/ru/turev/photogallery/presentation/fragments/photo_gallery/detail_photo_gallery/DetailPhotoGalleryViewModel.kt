package ru.turev.photogallery.presentation.fragments.photo_gallery.detail_photo_gallery

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.github.terrakok.cicerone.Router
import ru.turev.photogallery.presentation.base.BaseViewModel
import javax.inject.Inject

class DetailPhotoGalleryViewModel @Inject constructor(
    private val router: Router
) : BaseViewModel() {

    private val _stateLiveData = MutableLiveData<DetailPhotoGalleryView.Model>()
    val stateLiveData: LiveData<DetailPhotoGalleryView.Model> get() = _stateLiveData

    private var uiState = DetailPhotoGalleryView.Model()
        set(value) {
            field = value
            _stateLiveData.postValue(value)
        }

    fun onCloseClicked() {
        router.exit()
    }
}
