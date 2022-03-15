package com.gezhiwei.charactortest;

import org.junit.Test;

public class CharactorTest {

    @Test
    public void test() {
        char[] cs = new char[1024];
        String s = new String(cs);
        s.toCharArray();
    }


}
