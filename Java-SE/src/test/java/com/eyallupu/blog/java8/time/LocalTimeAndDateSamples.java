package com.eyallupu.blog.java8.time;

import org.junit.Test;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;

/**
 * @author eyal lupu
 */
public class LocalTimeAndDateSamples {

    // TODO immutable
    @Test
    public void localDate() {
        LocalDate localDate = LocalDate.of(2013, Month.AUGUST, 10);
        System.out.println(localDate); // Just a date, no TZ

        System.out.println(localDate.getDayOfWeek()); // It knows more than just the date
        System.out.println(localDate.getDayOfYear());
        System.out.println(localDate.getEra());

    }

    @Test
    public void localTime() {
        LocalTime localTime = LocalTime.of(22, 33);
        System.out.println(localTime);
        System.out.println(localTime.getHour());
    }

    @Test
    public void localDateTime() {
        // We can also combine the both
        LocalTime localTime = LocalTime.of(22, 33);
        LocalDateTime localDateTime = localTime.atDate(LocalDate.of(1971, Month.JANUARY, 23));
        System.out.println(localDateTime); //ISO8601

    }

    @Test
    public void locatTimeDateWithTZ() {
        // We can perform transformations using TZ, but still the result is not TZ related
        LocalDateTime localDateTime = LocalDateTime.now(ZoneId.of("UTC-10:00"));
        System.out.println(localDateTime);
    }

    @Test
    public void locatTimeDateCalculations() {

        LocalDateTime localDateTime = LocalDateTime.now();

        // Jump to 25 hours and 3 minutes into the future
        LocalDateTime inTheFuture = localDateTime.plusHours(25).plusMinutes(3);
        System.out.println(inTheFuture);

        // We could do the same on localTime or localDate
        System.out.println(localDateTime.toLocalTime().plusHours(25).plusMinutes(3));
        System.out.println(localDateTime.toLocalDate().plusMonths(2));

        // We could also use TemportalAmount (in this case a Duration and Period)
        System.out.println(localDateTime.toLocalTime().plus(Duration.ofHours(25).plusMinutes(3)));
        System.out.println(localDateTime.toLocalDate().plus(Period.ofMonths(2)));

    }

}
