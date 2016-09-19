package datetime;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class AntarcticaTimeZones {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        List<ZonedDateTime> antarticZones = ZoneId.getAvailableZoneIds().stream()
                .filter(id -> id.contains("Antarctica"))
                .map(id -> now.atZone(ZoneId.of(id)))
                .sorted(Comparator.comparingInt(zoneId ->
                        zoneId.getOffset().getTotalSeconds()))
                .collect(Collectors.toList());

        antarticZones.forEach(zdt ->
                System.out.printf("%s: %s%n", zdt.getOffset(), zdt.getZone()));
    }
}
