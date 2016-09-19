package geocoder;

public class Location {
    private String street;
    private String city;
    private String state;

    private double latitude;
    private double longitude;

    public Location() {}

    public Location(String street, String city, String state) {
        this.street = street;
        this.city = city;
        this.state = state;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String toString() {
        return String.format("%s, %s, %s(%s,%s)",
                street, city, state, latitude, longitude);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Location)) return false;

        Location location = (Location) o;

        if (street != null ? !street.equals(location.street) : location.street != null) return false;
        if (!city.equals(location.city)) return false;
        return state.equals(location.state);

    }

    @Override
    public int hashCode() {
        int result = street != null ? street.hashCode() : 0;
        result = 31 * result + city.hashCode();
        result = 31 * result + state.hashCode();
        return result;
    }
}
