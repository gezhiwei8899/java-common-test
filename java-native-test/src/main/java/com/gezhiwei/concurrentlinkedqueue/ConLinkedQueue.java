package com.gezhiwei.concurrentlinkedqueue;

import java.util.concurrent.ConcurrentLinkedQueue;

public class ConLinkedQueue {

    public static void main(String[] args) {
        ConcurrentLinkedQueue<Integer> linkedQueue = new ConcurrentLinkedQueue<>();
        linkedQueue.add(-1);
        linkedQueue.add(-2);
        System.out.println(linkedQueue);
    }
}
