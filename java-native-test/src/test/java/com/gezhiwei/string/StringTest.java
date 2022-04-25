package com.gezhiwei.string;

import org.junit.Test;

import java.util.Arrays;

public class StringTest {


    @Test
    public void suStringTest() {
        String a = "/aaa";
        String substring = a.substring(0, a.lastIndexOf("/") + 1 - 1);
        System.out.println(substring);




    }

    @Test
    public void test32() {
        int[] i = new int[2];
        System.out.println("i.length: " + i.length);

        for (int i1 : i) {
            System.out.println("i.for: " +i1);
        }

        System.out.println("i.0: " + i[0]);
        System.out.println("i.1: "+ i[1]);
    }
}
