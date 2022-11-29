package garcia.miguel.photogallery.api

import retrofit2.http.GET

interface FlickrApi {
    @GET("/")
    suspend fun fetchContents(): String
}