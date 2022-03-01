package com.gezhiwei.pritirty;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

public class PriotiyQueue {

    public static void main(String[] args) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(10, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        heap.add(6);
        heap.add(1);
        heap.add(2);
        heap.add(5);

        Integer peek = heap.peek();
        System.out.println(peek);


        while (!heap.isEmpty()){
            Integer poll = heap.poll();
            System.out.println(poll);
        }
        System.out.println(Arrays.toString(heap.toArray()));

    }
}
