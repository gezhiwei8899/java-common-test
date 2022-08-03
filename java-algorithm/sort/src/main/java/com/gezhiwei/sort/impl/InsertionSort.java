package com.gezhiwei.sort.impl;

import com.gezhiwei.sort.api.Sort;

import java.util.Arrays;

public class InsertionSort implements Sort {
    @Override
    public int[] sort(int[] arr, int n) {

        for (int i = 1; i < n; i++) {
            int value = arr[i];
            int j = i - 1;
            // 找插入的位置
            for (; j >= 0; j--) {
                if (arr[j] > value) {
                    arr[j + 1] = arr[j];
                } else {
                    break;
                }
            }
            arr[j + 1] = value;
        }

        return arr;
    }

    public static void main(String[] args) {
        Sort sort = new InsertionSort();
        int[] arr = {-1, -100, 100, 200, 68, 97, -45, 13, -27};
        int[] ans = sort.sort(arr, arr.length);
        System.out.println(Arrays.toString(ans));
    }
}
