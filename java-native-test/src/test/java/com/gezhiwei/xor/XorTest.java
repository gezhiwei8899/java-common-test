package com.gezhiwei.xor;

import org.junit.Test;

public class XorTest {


    /**
     * 偶数异或
     */
    @Test
    public void evenXor() {
        int mid = 8;
        int xor = mid ^ 1;
        System.out.println("mid ^ 1 = " + xor);
        System.out.println("mid + 1 = " + (mid + 1));
    }


    /**
     * 奇数异或
     */
    @Test
    public void oddNumberXor() {
        int mid = 7;
        int xor = mid ^ 1;
        System.out.println("mid ^ 1 = " + xor);
        System.out.println("mid - 1 = " + (mid - 1));
    }

    @Test
    public void bitShift() {
        int n = 2;
        System.out.println(n/2);
        System.out.println(n << 1);
        System.out.println(n >> 1);
    }

    @Test
    public void test() {
        int low = 3;
        int high = 4;
        int x = (high - low) / 2 + low;
        System.out.println(x);
    }

    @Test
    public void test2() {
        int low = 3;
        int high = 4;
        int x = ((high - low) >> 1) + low;
        int y = (high - low) >> 1 + low;
        System.out.println(x);
        System.out.println(y);
    }
}
