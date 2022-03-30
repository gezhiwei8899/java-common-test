package com.gezhiwei.locksupport;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;

public class LuckSupportTest {


    public static void main(String[] args) {

        Thread t = Thread.currentThread();
        LockSupport.unpark(t);
        LockSupport.park(t);
        t.interrupt();
        System.out.println(" park");


    }


    public boolean testPack() {
        try {
            Thread t = Thread.currentThread();
            LockSupport.park(t);
            t.interrupt();
            System.out.println(" park");
        }finally {

        }
        return false;
    }

    private final boolean parkAndCheckInterrupt() {
        LockSupport.park(this);
        return Thread.interrupted();
    }
}
