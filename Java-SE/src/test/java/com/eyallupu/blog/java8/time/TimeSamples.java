package com.eyallupu.blog.java8.time;

import org.junit.Test;

import java.time.Instant;

/**
 * @author eyal lupu
 */
public class TimeSamples {

    @Test
    public void getTheCurrentTime() {
        Instant now = Instant.now();
        System.out.println(now);
    }

}
