package com.gezhiwei.test.time;

import java.util.Date;

/**
 * @author gezhiwei
 */
public class TimeShow {

    public static void main(String[] args) {
        long now = new Date().getTime();
        long snow = System.currentTimeMillis();

        if (now == snow) {
            System.out.println(1111);
        }
    }

}
