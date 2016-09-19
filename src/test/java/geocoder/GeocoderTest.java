package geocoder;

import org.junit.Test;

import static org.hamcrest.Matchers.closeTo;
import static org.junit.Assert.*;

public class GeocoderTest {
    private Geocoder geocoder = new Geocoder();

    @Test
    public void checkHiltonSF() throws Exception {
        Location loc = new Location("333 O'Farrell Street", "San Francisco", "CA");
        geocoder.fillInLatLng(loc);

        assertThat(  37.79, closeTo(loc.getLatitude(), 0.1));
        assertThat(-122.41, closeTo(loc.getLongitude(), 0.1));
    }

    @Test
    public void whydahPirateMuseum() throws Exception {
        Location loc = new Location("674 Massachusetts 28", "West Yarmouth", "MA");
        geocoder.fillInLatLng(loc);

        assertThat( 41.65, closeTo(loc.getLatitude(), 0.1));
        assertThat(-70.22, closeTo(loc.getLongitude(), 0.1));
    }
}