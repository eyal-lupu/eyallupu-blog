package com.eyallupu.blog.java8.time;

import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;

/**
 * @author eyal lupu
 */
public class LocalTimeAndDate {

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
        System.out.println(localDateTime);

    }

}
