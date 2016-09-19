package geocoder

class Geocoder {
    public static final String BASE =
            'https://maps.googleapis.com/maps/api/geocode/xml?'

    void fillInLatLng(Location location) {
        String encoded = [location.street, location.city,
                          location.state].collect {
            URLEncoder.encode(it, 'UTF-8')
        }.join(',')
        String qs = "address=$encoded"
        def root = new XmlSlurper().parse("$BASE$qs")
        def loc = root.result[0].geometry.location
        location.latitude = loc.lat.toBigDecimal()
        location.longitude = loc.lng.toBigDecimal()
    }
}
