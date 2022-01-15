package com.gezhiwei.number;

import org.junit.Test;

public class IntegerComputeTest {

    @Test
    public void test1() {
        int n = 10;
        System.out.println(n % 7);
        System.out.println(n / 7);
    }

    @Test
    public void test2() {
        int n = 20;
        System.out.println(n % 7);
        System.out.println(n / 7);
    }

    @Test
    public void test4() {
        int n = 4;
        System.out.println(n % 7);
        System.out.println(n / 7);
    }

    @Test
    public void test5() {
        int p = 5;
        for (int v = p; v <= 5; ++v) {
            System.out.println(v);
        }
        for (int v = p; v <= 5; v++) {
            System.out.println(v);
        }
    }
}
