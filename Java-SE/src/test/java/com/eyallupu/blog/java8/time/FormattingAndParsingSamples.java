package com.eyallupu.blog.java8.time;

import org.junit.Test;

import java.time.Clock;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

/**
 * @author eyal lupu
 */
public class FormattingAndParsingSamples {

    @Test
    public void clockDefaultFormat() {
        Clock clock = Clock.systemDefaultZone();
        System.out.println("Clock default format: " + clock);
    }

    @Test
    public void instantDefaultFormat() {
        Instant instant = Instant.now();
        System.out.println("Instant default format: " + instant);
    }

    @Test
    public void preDefinedLocalizedFormatStylesDate() {

        for (FormatStyle formatStyle : FormatStyle.values()) {
            System.out.println("FormatStyle." + formatStyle + ": " + DateTimeFormatter.ofLocalizedDate(formatStyle).format(LocalDateTime.now()));
        }
    }

    @Test
    public void preDefinedLocalizedFormatStylesTime() {
        for (FormatStyle formatStyle : new FormatStyle[]{FormatStyle.SHORT, FormatStyle.MEDIUM}) {
            System.out.println("FormatStyle." + formatStyle + ": " + DateTimeFormatter.ofLocalizedTime(formatStyle).format(LocalTime.now()));
        }
    }

    @Test
    public void preDefinedLocalizedFormatStylesDateTime() {
        for (FormatStyle formatStyle : new FormatStyle[]{FormatStyle.SHORT, FormatStyle.MEDIUM}) {
            System.out.println("FormatStyle." + formatStyle + ": " + DateTimeFormatter.ofLocalizedDateTime(formatStyle).withLocale(Locale.US).format(LocalDateTime.now()));
        }
    }

    @Test
    public void preDefinedLocalizedFormatStyleDateWithTZ() {
        LocalDateTime now = LocalDateTime.now();
        System.out.println(DateTimeFormatter.ofLocalizedTime(FormatStyle.FULL).format(now));
        System.out.println(DateTimeFormatter.ofLocalizedTime(FormatStyle.FULL).withZone(ZoneId.of("America/New_York")).format(now));
    }
}
