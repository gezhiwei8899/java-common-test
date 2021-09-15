package com.gezhiwei.test.time;

import org.junit.Test;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class TestOtherCode {

    @Test
    public void test() {
        long now = new Date().getTime();
        long x = now % 1000;
        System.out.println(x);
        now = now - x;
        System.out.println(now);
    }

    @Test
    public void test1() {
        int i = 5;
        System.out.println(i%2);
    }

    @Test
    public void test2() {
        int i = 4;
        System.out.println(i%2);
    }

    @Test
    public void test3() {
        String time = "10:00:00.234";

    }

    @Test
    public void test4() {
        long now1 = new Date().getTime();
        now1 = now1 - (now1 % 1000);
        long now = LocalDateTime.now().atZone(ZoneId.systemDefault()).toEpochSecond() * 1000;
        System.out.println(now1 == now);
    }

    @Test
    public void test5() {
    }
}
