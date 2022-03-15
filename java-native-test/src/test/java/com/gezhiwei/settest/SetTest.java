package com.gezhiwei.settest;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class SetTest {


    @Test
    public void test() {
        Set<String> set = new HashSet<>();
        set.add("sfa");
        set.add("sfa");
        System.out.println(set);
    }
}
