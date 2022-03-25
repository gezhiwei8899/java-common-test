package com.gezhiwei.arr;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

class Solution2 {

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
//        int[][] dislikes = new int[][]{{1,2},{2,3},{3,4},{4,5},{1,5}};
        int[][] dislikes = new int[][]{{1,2},{1,3},{1,4},{1,5},{1,8},{1,6},{1,9},{1,7},{1,10}};
//        int n = 5;
        int n = 10;
        boolean b = solution2.possibleBipartition(n, dislikes);
        System.out.println(b);
    }

    List<List<Integer>> rec;
    boolean[] vis;

    public boolean possibleBipartition(int n, int[][] dislikes) {
        int m = dislikes.length;
        rec = new ArrayList<>();
        vis = new boolean[m];
        List<Unit> arr = new ArrayList<>();
        res(dislikes, 0, m, arr);
        for(int i = 0; i < rec.size(); i++){
            List<Integer> list = rec.get(i);
            Map<Integer, Long> map = list.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
            if (map.values().stream().allMatch(p -> p == 2)) {
                return false;
            }
        }

        return true;
    }

    public void res(int[][] dislikes, int cszie, int n, List<Unit> arr){
        //终止条件
        if(cszie == 3){
            List<Integer> arrs = new ArrayList<>();
            for (Unit unit : arr) {
                List<Integer> data = unit.data();
                arrs.addAll(data);
            }
            rec.add(arrs);
            return;
        }
        for (int j = 0; j < n; j++) {
            if (vis[j]) {
                continue;
            }
            vis[j] = true;
            int[] a = dislikes[j];
            Unit unit = new Unit(a);
            arr.add(unit);
            res(dislikes, cszie + 1, n, arr);
            arr.remove(unit);
            vis[j] = false;
        }
    }

    static class Unit {
        int[] a;

        public Unit(int[] unitArr){
            this.a = unitArr;
        }

        @Override
        public boolean equals(Object obj){
            if (this == obj) {
                return true;
            }
            Unit b = (Unit) obj;
            boolean b1 = a[0] == b.index(0) && a[1] == b.index(1);
            return b1;
        }

        public int index(int i){
            return a[i];
        }

        public List<Integer> data() {
            List<Integer> integers = new ArrayList<>();
            for (int i : a) {
                integers.add(i);
            }
            return integers;
        }

    }
}
