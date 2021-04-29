package geocoder;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.closeTo;
import static org.junit.jupiter.api.Assertions.assertAll;

public class GeocoderTest {
    private final Geocoder geocoder = new Geocoder();

    @Test
    public void mosconeWest() {
        Location loc = new Location("Moscone West", "San Francisco", "CA");
        geocoder.fillInLatLng(loc);

        assertAll(
                () -> assertThat(37.7843, closeTo(loc.getLatitude(), 0.1)),
                () -> assertThat(-122.4007, closeTo(loc.getLongitude(), 0.1))
        );
    }

    @Test
    public void bengaluru() {
        Location loc = new Location("J N Tata Auditorium", "Bangalore", "India");
        geocoder.fillInLatLng(loc);

        assertAll(
                () -> assertThat(13.0134, closeTo(loc.getLatitude(), 0.1)),
                () -> assertThat(77.56792, closeTo(loc.getLongitude(), 0.1))
        );
    }
}