package com.gezhiwei.hash.map;

import org.junit.Test;

import java.sql.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HTest {


    @Test
    public void test() {
        Map<Integer, Integer> map = new HashMap<>();
        map.computeIfAbsent(1,v->{
            if (null==v) {
                return 1;
            }
            return  v + 1;
        });

        map.merge(1,1, Integer::sum);
    }

    @Test
    public void test2() {
        List<Integer> a = new ArrayList<>();
        List<Integer> b = new ArrayList<>();

        a.add(null);
        

    }
}
