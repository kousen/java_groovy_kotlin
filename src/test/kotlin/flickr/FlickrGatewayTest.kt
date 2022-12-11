package flickr

import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test

class FlickrGatewayTest {
    private val gateway = FlickrGateway()

    @Test // @Disabled
    fun `get kitties from Flickr`() {
        runBlocking {
            val flickrResult = gateway.retrofitService.getFlickrResult("kitties")
            println(flickrResult)
            for (p in flickrResult.photos.photo) {
                println("https://farm${p.farm}.staticflickr.com/${p.server}/${p.id}_${p.secret}.jpg")
            }
        }
    }

    @Test
    fun `get the images`() = runBlocking {
        val images = gateway.flickrResult2Image()
        println("There are ${images.size} images")
    }
}