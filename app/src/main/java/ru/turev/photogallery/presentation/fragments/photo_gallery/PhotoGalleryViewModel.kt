package ru.turev.photogallery.presentation.fragments.photo_gallery

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.github.terrakok.cicerone.Router
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import ru.turev.photogallery.data.network.api.response.PhotoResponse
import ru.turev.photogallery.domain.entity.ItemPhoto
import ru.turev.photogallery.domain.enums.State
import ru.turev.photogallery.domain.repository.PhotoRepository
import ru.turev.photogallery.presentation.base.BaseViewModel
import javax.inject.Inject

class PhotoGalleryViewModel @Inject constructor(
    private val photoRepository: PhotoRepository,
    private val router: Router
) : BaseViewModel() {

    private val _stateLiveData = MutableLiveData<PhotoGalleryView.Model>()
    val stateLiveData: LiveData<PhotoGalleryView.Model> get() = _stateLiveData

    private var uiState = PhotoGalleryView.Model()
        set(value) {
            field = value
            // todo
            _stateLiveData.postValue(value)
        }

    private fun getAllPhotos() {
        photoRepository.getAllPhotos(1, 20)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            //.compose(loadingSingleCompose())
            .subscribe(::handleItems, ::handleError)
            .also{ disposeOnCleared(it) }
    }


    private fun handleItems(items: List<PhotoResponse>) {
        uiState = PhotoGalleryView.Model(
            items = items,
            error = State.COMPLETE
        )
        Log.d("qqqq", "items : ${items}")
    }

    private fun handleError(error: Throwable) {
        uiState = PhotoGalleryView.Model(
            items = emptyList(),
            error = State.ERROR
        )
      //  processError(error)
    }

    init {
        getAllPhotos()
    }
}
