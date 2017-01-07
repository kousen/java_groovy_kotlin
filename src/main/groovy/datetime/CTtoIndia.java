package datetime;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.stream.IntStream;

public class CTtoIndia {
    public static void main(String[] args) {
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.MIDNIGHT;
        ZonedDateTime zdt = ZonedDateTime.of(localDate, localTime,
                ZoneId.of("America/New_York"));
        ZoneId india = ZoneId.of("Asia/Kolkata");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mma");

        System.out.println("Connecticut India");
        IntStream.rangeClosed(20, 30)  // start at 8pm, incr by 1 hr 10 times
                .mapToObj(zdt::plusHours)
                .forEach(zonedDateTime -> System.out.printf("  %s   %s%n",
                        zonedDateTime.toLocalTime().format(formatter),
                        zonedDateTime.withZoneSameInstant(india).toLocalTime()));
    }
}
