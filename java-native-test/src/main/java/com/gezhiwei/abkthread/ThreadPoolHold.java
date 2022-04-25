package com.gezhiwei.abkthread;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadPoolHold {

    private AtomicInteger atomicInteger = new AtomicInteger();

    private static final ThreadPoolExecutor THREAD_POOL_EXECUTOR = new ThreadPoolExecutor(10, 10, 0, TimeUnit.SECONDS, new LinkedBlockingQueue<>(10),
            r -> new Thread(r, "xx-"),
            (r, executor) -> {
                BlockingQueue<Runnable> queue = executor.getQueue();
                try {
                    queue.put(r);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });


    public void submit(Runnable r) {
        int andIncrement = atomicInteger.getAndIncrement();
        System.out.println("Task: " + andIncrement);
        THREAD_POOL_EXECUTOR.submit(r);
    }
}
