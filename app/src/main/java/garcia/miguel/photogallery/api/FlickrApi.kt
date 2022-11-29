package garcia.miguel.photogallery.api

import retrofit2.http.GET

private const val API_KEY = "ba9b01fc260b155e42397ae0e7099327"

interface FlickrApi {
    @GET(
        "services/rest/?method=flickr.interestingness.getList" +
                "&api_key=$API_KEY" +
                "&format=json" +
                "&nojsoncallback=1" +
                "&extras=url_s"
    )
    fun fetchPhotos(): FlickrResponse
}