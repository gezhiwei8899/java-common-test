package com.gezhiwei.priority;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityTest {

    public static void main(String[] args) {
        PriorityQueue<Integer> bigRoot = new PriorityQueue<>(Comparator.comparing(Integer::intValue).reversed());
        PriorityQueue<Integer> smallRoot = new PriorityQueue<>(Comparator.comparing(Integer::intValue).reversed());
    }
}
