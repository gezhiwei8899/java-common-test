package com.gezhiwei.sort;

import com.gezhiwei.sort.api.Sort;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {

    static Map<Integer, Sort> sortMap = new ConcurrentHashMap<>();
    static AtomicInteger atomicInteger = new AtomicInteger(0);

    public static void main(String[] args) {

    }
}
