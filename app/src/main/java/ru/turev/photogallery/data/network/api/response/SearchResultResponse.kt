package ru.turev.photogallery.data.network.api.response

import com.google.gson.annotations.SerializedName

data class SearchResultResponse(
    @SerializedName("results")
    val images: List<PhotoResponse>
)
