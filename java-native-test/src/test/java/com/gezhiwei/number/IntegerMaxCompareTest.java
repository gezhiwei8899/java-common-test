package com.gezhiwei.number;

import org.junit.Test;

public class IntegerMaxCompareTest {
    @Test
    public void teset1() {

        int pow = 6;

        int ans = 10;

        for (int i = 0; i < pow; i++) {
            ans = ans * 10;
        }

        System.out.println(ans);
    }

    @Test
    public void testInteger() {
        int max = Integer.MAX_VALUE;
        System.out.println(max);
        int total = max;
        int count = 0;
        while (total > 0){
            total = total / 10;
            count++;
        }
        System.out.println(count);
    }
}
