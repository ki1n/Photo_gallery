package ru.turev.photogallery.util.exstension

import androidx.lifecycle.MutableLiveData

fun <T> MutableLiveData<T>.accept(value: T) {
    this.value = value
}
