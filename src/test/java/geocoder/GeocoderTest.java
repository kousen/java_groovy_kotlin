package geocoder;


import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.closeTo;

public class GeocoderTest {
    private Geocoder geocoder = new Geocoder();

    @Test
    public void mosconeWest() {
        Location loc = new Location("Moscone West", "San Francisco", "CA");
        geocoder.fillInLatLng(loc);

        assertThat(37.7843, closeTo(loc.getLatitude(), 0.1));
        assertThat(-122.4007, closeTo(loc.getLongitude(), 0.1));
    }

    @Test
    public void whydahPirateMuseum() {
        Location loc = new Location("674 Massachusetts 28", "West Yarmouth", "MA");
        geocoder.fillInLatLng(loc);

        assertThat(41.65, closeTo(loc.getLatitude(), 0.1));
        assertThat(-70.22, closeTo(loc.getLongitude(), 0.1));
    }
}