package garcia.miguel.photogallery

import garcia.miguel.photogallery.api.FlickrApi
import garcia.miguel.photogallery.api.GalleryItem
import garcia.miguel.photogallery.api.PhotoInterceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class PhotoRepository {
    private val flickrApi: FlickrApi
    init {
        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(PhotoInterceptor())
            .build()

        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("https://api.flickr.com/")
            .addConverterFactory(MoshiConverterFactory.create())
            .client(okHttpClient)
            .build()
        flickrApi = retrofit.create()
    }
    suspend fun fetchPhotos(): List<GalleryItem> =
        flickrApi.fetchPhotos().photos.galleryItems

    suspend fun searchPhotos(query: String): List<GalleryItem> =
        flickrApi.searchPhotos(query).photos.galleryItems
}
