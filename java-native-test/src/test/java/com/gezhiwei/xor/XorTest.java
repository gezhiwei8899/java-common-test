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

}
