package ru.turev.photogallery.domain.entity

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ItemPhoto(
    val id: String,
    val raw: String,
    val full: String,
    val regular: String,
    val small: String,
    val thumb: String,
    val smallS3: String,
    val likes: Int,
    val name: String
    //  val tagline: String
) : Parcelable
