package ru.turev.photogallery.data.network.mapper

import ru.turev.photogallery.data.network.api.response.PhotoResponse
import ru.turev.photogallery.domain.entity.ItemPhoto

class PhotoResponseMapper {

    fun mapToDomain(response: List<PhotoResponse>): List<ItemPhoto> {
        val result = mutableListOf<ItemPhoto>()
        response.forEach {
            result.add(
                ItemPhoto(
                    id = it.id,
                    raw = it.urls.raw,
                    full = it.urls.full,
                    regular = it.urls.regular,
                    small = it.urls.small,
                    thumb = it.urls.thumb,
                    smallS3 = it.urls.smallS3,
                    likes = it.likes,
                    tagline = it.sponsorship.tagline
                )
            )
        }
        return result
    }
}
