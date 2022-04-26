package ru.turev.photogallery.presentation.fragments.photo_gallery

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.github.terrakok.cicerone.Router
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import ru.turev.photogallery.domain.entity.ItemPhoto
import ru.turev.photogallery.domain.enums.State
import ru.turev.photogallery.domain.repository.PhotoRepository
import ru.turev.photogallery.navigation.Screens
import ru.turev.photogallery.presentation.base.BaseViewModel
import ru.turev.photogallery.util.exstension.empty
import javax.inject.Inject

class PhotoGalleryViewModel @Inject constructor(
    private val photoRepository: PhotoRepository,
    private val router: Router
) : BaseViewModel() {

    private val _stateLiveData = MutableLiveData<PhotoGalleryView.Model>()
    val stateLiveData: LiveData<PhotoGalleryView.Model> get() = _stateLiveData

    fun onDetailPhotoGalleryScreen(itemPhoto: ItemPhoto) =
        router.navigateTo(Screens.detailPhotoGalleryScreen(itemPhoto))

    private var uiState = PhotoGalleryView.Model()
        set(value) {
            field = value
            _stateLiveData.postValue(value)
        }

    fun onSearchInputUpdate(searchInput: String) {
        uiState = uiState.copy(searchInput = searchInput, searchInputEmpty = false)
    }

    fun onSearch() {
        getSearchPhotos(uiState.searchInput)
    }

    fun onClear() {
        uiState = uiState.copy(searchInput = String.empty, searchInputEmpty = true)
    }

    private fun getAllPhotos() {
        photoRepository.getAllPhotos(INITIAL_VALUE, STANDARD_QUANTITY)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .compose(loadingSingleCompose())
            .subscribe(::handleItems, ::handleError)
            .also { disposeOnCleared(it) }
    }

    private fun getSearchPhotos(searchInput: String) {
        photoRepository.getSearchPhotos(searchInput, STANDARD_QUANTITY)
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

    companion object {
        private const val STANDARD_QUANTITY = 20
        private const val INITIAL_VALUE = 1
    }
}
