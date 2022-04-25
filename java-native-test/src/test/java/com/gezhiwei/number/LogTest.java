package com.gezhiwei.number;

import org.junit.Test;

public class LogTest {


    @Test
    public void test() {
        int xx = 4;
        double log = Math.sqrt(xx);
        if (Double.compare(log, 2.0) == 0) {
            System.out.println(true);
        }
        System.out.println(log);
    }

    @Test
    public void test1() {
        double pow = Math.pow(2, 32);
        long i = (long) pow;
        System.out.println(i);
        System.out.println((i >> 1) - 1);
        System.out.println((i >> 1) - 1);
        System.out.println(Integer.MAX_VALUE);

        double l = (i << 2) / 1000000 /3600;
        System.out.println(l);
    }

    @Test
    public void testDouble() {
        double maxValue = Double.MAX_VALUE;
        System.out.println(maxValue);
    }
}
