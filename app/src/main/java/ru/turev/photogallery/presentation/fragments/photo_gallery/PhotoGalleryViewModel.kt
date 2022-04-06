package ru.turev.photogallery.presentation.fragments.photo_gallery

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.github.terrakok.cicerone.Router
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import ru.turev.photogallery.domain.entity.ItemPhoto
import ru.turev.photogallery.domain.enums.State
import ru.turev.photogallery.domain.interactor.PhotoInteractor
import ru.turev.photogallery.domain.repository.PhotoRepository
import ru.turev.photogallery.presentation.base.BaseViewModel
import timber.log.Timber
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
            _stateLiveData.value = value
        }

    private fun getAllPhotos() {
        photoRepository.getAllPhotos(1, 20)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .compose(loadingSingleCompose())
            .subscribe(::handleItems, ::handleError)
            .also { disposeOnCleared(it) }
    }


    private fun handleItems(items: List<ItemPhoto>) {
        uiState = PhotoGalleryView.Model(
            items = items,
            error = State.COMPLETE
        )
        Timber.d("items : $items")
    }

    private fun handleError(error: Throwable) {
        uiState = PhotoGalleryView.Model(
            items = emptyList(),
            error = State.ERROR
        )
        processError(error)
    }

    init {
        getAllPhotos()
    }
}
