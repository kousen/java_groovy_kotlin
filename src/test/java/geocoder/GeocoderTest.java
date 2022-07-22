package geocoder;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.byLessThan;
import static org.junit.jupiter.api.Assertions.assertAll;

public class GeocoderTest {
    private final Geocoder geocoder = new Geocoder();

    @Test
    public void mosconeWest() {
        Location loc = new Location("Moscone West", "San Francisco", "CA");
        geocoder.fillInLatLng(loc);

        assertAll(
                () -> assertThat(37.7843).isCloseTo(loc.getLatitude(), byLessThan(0.01)),
                () -> assertThat(-122.4007).isCloseTo(loc.getLongitude(), byLessThan(0.01))
        );
    }

    @Test
    public void bengaluru() {
        Location loc = new Location("J N Tata Auditorium", "Bangalore", "India");
        geocoder.fillInLatLng(loc);

        assertAll(
                () -> assertThat(13.0134).isCloseTo(loc.getLatitude(), byLessThan(0.1)),
                () -> assertThat(77.56792).isCloseTo(loc.getLongitude(), byLessThan(0.1))
        );
    }
}