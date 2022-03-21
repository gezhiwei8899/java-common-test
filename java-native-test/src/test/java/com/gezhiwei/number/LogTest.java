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
}
