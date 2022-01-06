package com.gezhiwei.object.test;

public class ObjectTest {


    public static void main(String[] args) {
        Integer i = 1;
        Class<? extends Integer> clazz = i.getClass();
        System.out.println(clazz);
    }
}
