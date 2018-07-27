package geocoder

import groovy.json.JsonSlurper

class Geocoder {
    public static final String BASE =
            'https://maps.googleapis.com/maps/api/geocode/json?'
    private static final String KEY =
            'AIzaSyDw_d6dfxDEI7MAvqfGXEIsEMwjC1PWRno'

    void fillInLatLng(Location location) {
        String encoded = [location.street, location.city,
                          location.state].collect {
            URLEncoder.encode(it, 'UTF-8')
        }.join(',')
        String qs = "address=$encoded&key=$KEY"
        def root = new JsonSlurper().parse("$BASE$qs")
        def loc = root.results[0].geometry.location
        location.latitude = loc.lat.toBigDecimal()
        location.longitude = loc.lng.toBigDecimal()
    }
}
