package ru.turev.photogallery.data.network.api

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query
import ru.turev.photogallery.BuildConfig
import ru.turev.photogallery.data.network.api.response.PhotoResponse
import ru.turev.photogallery.data.network.api.response.SearchResultResponse

interface ApiService {

    @Headers("Authorization: Client-ID ${BuildConfig.API_KEY}")
    @GET("/photos")
    fun getAllPhotos(
        @Query("page") page: Int,
        @Query("per_page") perPage: Int
    ): Single<List<PhotoResponse>>

    @Headers("Authorization: Client-ID ${BuildConfig.API_KEY}")
    @GET("/search/photos")
    fun getSearchPhotos(
        @Query("query") query: String,
        @Query("per_page") perPage: Int
    ): Single<SearchResultResponse>
}
