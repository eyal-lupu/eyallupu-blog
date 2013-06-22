package com.eyallupu.blog.java8.time;

import org.junit.Test;

import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoUnit;

/**
 * @author Eyal Lupu
 */
public class InstantSamples {

    @Test
    public void testGetCurrentTime() {

        // Get the current time, and print it.
        Instant instant = Instant.now();

        // Output format is ISO-8601
        System.out.println(instant);
    }

    @Test
    public void testInstantCalculation() {
        Instant instant = Instant.now();
        System.out.println(instant);

        Instant instant1 = instant.plus(Duration.ofHours(5).plusMinutes(4));
        System.out.println(instant1);

        System.out.println("Instant is immutable, so instant==instant returns: " + (instant == instant1));

        long diffAsMinutes = instant.periodUntil(instant1, ChronoUnit.MINUTES);
        System.out.format("[opt 1]Between %s and %s there are %d %s.%n", instant, instant1, diffAsMinutes, ChronoUnit.MINUTES);

        // Here is another way
        System.out.format("[opt 2]Between %s and %s there are %d %s.%n", instant, instant1, ChronoUnit.MINUTES.between(instant, instant1), ChronoUnit.MINUTES);


        // We can check to see which Instant is before/after the other
        System.out.format("instant1.isAfter(instant)=%b, instant1.isBefore(instant)=%b.%n", instant1.isAfter(instant), instant1.isBefore(instant));

        // or just to compare the two
        System.out.format("instant1.compareTo(instant)=%d.%n", instant1.compareTo(instant));
    }
}
