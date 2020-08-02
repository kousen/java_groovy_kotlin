package flickr

import groovy.swing.SwingBuilder

import javax.imageio.ImageIO
import javax.swing.*

String imageLoc = 'https://farm66.staticflickr.com/65535/50176935348_9c8abe02d5.jpg'

new SwingBuilder().edt {
    frame(title: 'Cat picture', pack: true, show: true,
            locationRelativeTo: null,
            defaultCloseOperation: JFrame.EXIT_ON_CLOSE) {

        label(icon: imageIcon(image: ImageIO.read(imageLoc.toURL())))
    }
}