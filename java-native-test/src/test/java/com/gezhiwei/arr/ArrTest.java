package com.gezhiwei.arr;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrTest {


    @Test
    public void test() {
        int[] nums = new int[12];
        Arrays.sort(nums);

        String a = "";
        String[] split = a.split("");

    }

    @Test
    public void test3() {
        int[][] grid = new int[1][3];
        int length = grid.length;
        int t = grid[0].length;
    }

    @Test
    public void test4() {
        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(3);
        list.add(2);
        list.add(6);
        list.add(3);
        list.add(6);
        int s = list.get(0) ^ list.get(1) ^ list.get(2) ^ list.get(3) ^ list.get(4) ^ list.get(5);
        System.out.println(s);
    }


    @Test
    public void test5() {
        int t = 1 ^ 4 ^ 1 ^ 4 ^ 1 ^ 7;
        System.out.println(t);
    }
}
