package com.gezhiwei.huawei;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNext()) {
            int n = in.nextInt();

            int _sum_3 = 0;
            int _sum_5 = 0;
            int sum = 0;
            List<Integer> left = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                int _int = in.nextInt();
                if (_int % 3 == 0) {
                    _sum_3 = _int + _sum_3;
                    continue;
                }
                if (_int % 5 == 0) {
                    _sum_5 = _sum_5 + _int;
                    continue;
                }
                sum = sum + _int;
                left.add(_int);
            }
            int div = (sum + _sum_5 + _sum_3) - _sum_3;
            if ((sum  + _sum_3 + _sum_5) % 2 != 0) {
                System.out.println(false);
            } else {
                System.out.println(dfs(0, left, div));
            }
        }
    }

    // 为什么在left数组里 找到div就行了？


    public static boolean dfs(int i, List<Integer> left, int div) {
        // 终止条件
        if (i == left.size()) {
            return div == 0;
        }
        return dfs(i + 1, left, div - left.get(i)) || dfs(i + 1, left, div);
    }


}