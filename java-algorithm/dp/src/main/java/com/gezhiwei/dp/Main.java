package com.gezhiwei.dp;

/**
 * @author gezhiwei
 */
public class Main {

    public static void main(String[] args) {
        FindMaxValue findMaxValue = new FindMaxValue();
        FindMaxValueUseLessSpace valueUseLessSpace = new FindMaxValueUseLessSpace();
        // 结果放到maxV中
        int maxV = Integer.MIN_VALUE;
        // 物品的重量
        int[] items = {2, 2, 4, 6, 3};
        // 物品的价值
        int[] value = {3, 4, 8, 9, 6};
        // 物品个数
        int n = 5;
        // 背包承受的最大重量
        int w = 9;

        int kidnap = findMaxValue.kidnap(items, value, n, w);
        int kindap1 = valueUseLessSpace.kidnap(items, value, n, w);
        System.out.println(kidnap);
        System.out.println(kindap1);
    }
}
