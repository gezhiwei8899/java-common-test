package com.gezhiwei.stacktrace;

/**
 * @author gezhiwei
 */
public class Main {


    public static void main(String[] args) {
        Test test = new Test();
        System.out.println("test1 invoker...");
        test.test1();
        System.out.println();
        System.out.println();
        System.out.println("test2 invoker...");
        test.test2();
        System.out.println();
        System.out.println();
        System.out.println("test3 invoker...");
        test.test3();
        System.out.println();
        System.out.println();
    }
}
