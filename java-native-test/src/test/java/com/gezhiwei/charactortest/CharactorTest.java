package com.gezhiwei.charactortest;

import org.junit.Test;

public class CharactorTest {

    @Test
    public void test() {
        char[] cs = new char[1024];
        String s = new String(cs);
        s.toCharArray();
    }


    @Test
    public void testCharNumber() {
        char a = 'a';
        char b = 'z';

        int c = abs(a, b);

        System.out.println(c);
    }

    private int abs(char a, char b) {
        int v = a - b;
        if (v < 0) {
            return v + 26;
        }
        return v;
    }
}
