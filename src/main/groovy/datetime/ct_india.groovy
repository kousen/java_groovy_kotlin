package datetime

import java.time.*
import java.time.format.*
LocalDate localDate = LocalDate.now()
LocalTime localTime = LocalTime.MIDNIGHT
ZonedDateTime zdt = ZonedDateTime.of(localDate, localTime,
        ZoneId.of('America/New_York'))
ZoneId india = ZoneId.of('Asia/Kolkata')
DateTimeFormatter dtf = DateTimeFormatter.ofPattern('hh:mma')
println "Connecticut India"
(20..30).each {
    ZonedDateTime shifted = zdt.plusHours(it)
    println "  ${shifted.toLocalTime().format(dtf)}   ${shifted.withZoneSameInstant(india).toLocalTime()}"
}
