package ru.turev.photogallery.data.network.api.response

import com.google.gson.annotations.SerializedName

data class PhotoResponse(
    @SerializedName("id")
    val id: String,
    @SerializedName("urls")
    val urls: Urls,
    @SerializedName("likes")
    val likes: Int,
    @SerializedName("sponsorship")
    val sponsorship: Sponsorship
)

data class Urls(
    @SerializedName("raw")
    val raw: String,
    @SerializedName("full")
    val full: String,
    @SerializedName("regular")
    val regular: String,
    @SerializedName("small")
    val small: String,
    @SerializedName("thumb")
    val thumb: String,
    @SerializedName("smallS3")
    val smallS3: String
)

data class Sponsorship(
    @SerializedName("tagline")
    val tagline: String
)

