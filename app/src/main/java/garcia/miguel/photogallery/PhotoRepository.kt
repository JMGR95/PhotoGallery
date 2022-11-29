package garcia.miguel.photogallery

import garcia.miguel.photogallery.api.FlickrApi
import garcia.miguel.photogallery.api.GalleryItem
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class PhotoRepository {
    private val flickrApi: FlickrApi
    init {
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("https://api.flickr.com/")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
        flickrApi = retrofit.create()
    }
    suspend fun fetchPhotos(): List<GalleryItem> =
        flickrApi.fetchPhotos().photos.galleryItems
}
