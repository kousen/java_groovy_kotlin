package flickr

import groovy.json.JsonOutput
import groovy.json.JsonSlurper
import groovy.swing.SwingBuilder

import javax.imageio.ImageIO
import javax.swing.WindowConstants as WC
import java.awt.*
import java.util.List
import java.util.stream.Collectors

String endPoint = 'https://api.flickr.com/services/rest?'
def params = [method        : 'flickr.photos.search',
              api_key       : new File('flickr_key.txt').text,
              format        : 'json',
              tags          : 'cats',
              nojsoncallback: 1,
              media         : 'photos',
              per_page      : 6]

// Build URL and download JSON data
def queryString = params.collect { it }.join('&')
String jsonTxt = "$endPoint$queryString".toURL().text

// write formatted JSON data to file
File f = new File('cats.json')
if (f) f.delete()
f << JsonOutput.prettyPrint(jsonTxt)
println JsonOutput.prettyPrint(jsonTxt)

// parse JSON data and extract photo elements
def json = new JsonSlurper().parseText(jsonTxt)
def photos = json.photos.photo

Image photo2image(p) {
    println "${Thread.currentThread().name}: ${p.title}"
    String url = "https://farm${p.farm}.staticflickr.com/${p.server}/${p.id}_${p.secret}.jpg"
    ImageIO.read(url.toURL())
}

// download images
List<Image> images = photos.parallelStream()  // For fun, change to parallelStream
        .map(this::photo2image)
        .collect(Collectors.toList())

// build UI using Swing
new SwingBuilder().edt {
    frame(title: 'Cat pictures', visible: true,
            pack: true,
            layout: gridLayout(rows: 3, cols: 2),
            defaultCloseOperation: WC.EXIT_ON_CLOSE) {
        images.each { image ->
            label(icon: imageIcon(image: image))
        }
    }
}
