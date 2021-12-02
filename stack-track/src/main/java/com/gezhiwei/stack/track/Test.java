package com.gezhiwei.stack.track;

import static com.gezhiwei.stack.track.Utils.getMethod;

public class Test {



    public void test1() {
        StackTraceElement element = Thread.currentThread().getStackTrace()[1];
        String methodName = element.getMethodName();
        System.out.println(methodName);

        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        for (StackTraceElement stackTraceElement : stackTrace) {
            String methodName1 = stackTraceElement.getMethodName();
            System.out.println(methodName1);
        }
    }


    public void test2() {
        System.out.println(getMethod());
    }


    public void test3() {
        StackTraceElement element = Thread.currentThread().getStackTrace()[0];
        String methodName = element.getMethodName();
        System.out.println(methodName);
    }
}
