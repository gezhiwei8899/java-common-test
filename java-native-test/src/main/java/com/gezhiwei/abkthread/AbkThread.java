package com.gezhiwei.abkthread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author gezhiwei
 */
public class AbkThread {

    static AtomicInteger atomicInteger = new AtomicInteger(-1000000000);

    public static void main(String[] args) {
        ThreadPoolHold threadPoolHold = new ThreadPoolHold();
        for (int i = 0; i < 10000; i++) {
            threadPoolHold.submit(()->{
                try {
                    int andIncrement = atomicInteger.getAndIncrement();
                    Thread.sleep(5000);
                    System.out.println("Task Finish: " + andIncrement);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }
    }
}
