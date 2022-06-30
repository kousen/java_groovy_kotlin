package flickr

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.coroutines.*
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import okhttp3.MediaType
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Query
import java.io.File
import java.net.URL
import javax.imageio.ImageIO

class FlickrGateway {

    companion object {
        val key = File("flickr_key.txt").readText()
    }

    @OptIn(ExperimentalSerializationApi::class)
    val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://api.flickr.com/")
        .addConverterFactory(
            Json.asConverterFactory(MediaType.get("application/json"))
        )
        .build()

    val retrofitService: FlickrService by lazy {
        retrofit.create(FlickrService::class.java)
    }

    // Problem: Retrofit needs the baseurl argument to @GET to be a compile-time constant
    //    but Flickr generates the photo urls from the individual photo objects
    // So have to do everything manually instead
    suspend fun flickrResult2Image() = coroutineScope {
        val photoList = retrofitService.getFlickrResult("kitties")
            .photos.photo
        photoList.map { p ->
            val url = "https://farm${p.farm}.staticflickr.com/${p.server}/${p.id}_${p.secret}.jpg"
            async {
                withContext(Dispatchers.IO) {
                    println("${Thread.currentThread()} ${p.title}")
                    ImageIO.read(URL(url))
                }
            }
        }.awaitAll()
    }
}

interface FlickrService {
    @GET("services/rest")
    suspend fun getFlickrResult(
        @Query("tags") tags: String,
        @Query("method") method: String = "flickr.photos.search",
        @Query("api_key") api_key: String = FlickrGateway.key,
        @Query("format") format: String = "json",
        @Query("nojsoncallback") nojsoncallback: Int = 1,
        @Query("media") media: String = "photos",
        @Query("per_page") per_page: Int = 6
    ): FlickrResult
}

@Serializable
data class FlickrResult(
    val photos: PhotoComposite,
    val stat: String,
)

@Serializable
data class PhotoComposite(
    val page: Int,
    val pages: Int,
    val perpage: Int,
    val total: Int,
    val photo: List<Photo>,
)

@Serializable
data class Photo(
    val id: Long,
    val owner: String,
    val secret: String,
    val server: Int,
    val farm: Int,
    val title: String,
    val ispublic: Int,
    val isfriend: Int,
    val isfamily: Int,
)
