package com.gezhiwei;

import org.junit.Test;

public class IntegerBinaryTest {

    @Test
    public void max() {
        String s = Integer.toBinaryString(Integer.MAX_VALUE);
        System.out.println("Integer Max: " + Integer.MAX_VALUE);
        System.out.println("Integer Max Binary:" + s);
        System.out.println("Integer Max Binary Length: " + s.length());
    }

    @Test
    public void test1() {
        int i = Integer.MAX_VALUE - 2655527;
        String s = Integer.toBinaryString(i);
        System.out.println("Integer Max - 2655527: " + i);
        System.out.println("Integer Max - 2655527 Binary:" + s);
        System.out.println("Integer Max - 2655527 Binary Length: " + s.length());
    }

    @Test
    public void test2() {
        int addr = Integer.MAX_VALUE - 2655527;
        System.out.println("Integer addr Binary:" + Integer.toBinaryString(addr));
        int r = addr >> 6;
        //addr: 01 111111 110101 110111 101011 011000
        //   r: 00 000001 111111 110101 110111 101011
        //0x1f: 00000000000000000000000000011111
        //   i: 00000000000000000000000000001011
        System.out.println(r);
        System.out.println(Integer.toBinaryString(r));
        int i = r & 0x1F;

        // 0111,1111,1101,0111,0111,1010,1101,1000
        System.out.println(i);
        System.out.println(Integer.toBinaryString(i));
    }

    @Test
    public void test4() {
        System.out.println(Integer.toBinaryString(0x1F));
    }

    @Test
    public void test3() {
        Integer i = 0x1F;
        System.out.println(i);
    }

    @Test
    public void min() {
        String s = Integer.toBinaryString(Integer.MIN_VALUE);
        System.out.println("Integer Min: " + Integer.MIN_VALUE);
        System.out.println("Integer Min Binary:" + s);
        System.out.println("Integer Min Binary Length: " + s.length());
    }
}
