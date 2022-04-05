package ru.turev.photogallery.util.exstension

import android.text.TextUtils

fun inputCheckText(name: String): Boolean {
    return !(TextUtils.isEmpty(name))
}
