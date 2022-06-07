package com.gezhiwei.sort.impl;

import com.gezhiwei.sort.api.Sort;

import java.util.Arrays;

public class BubbleSort implements Sort {
    @Override
    public int[] sort(int[] arr, int n) {
        for (int i = 0; i < n; i++) {
            // in one loop ,there no swap happens. So We think the arr has been sorted.
            boolean flag = false;
            // some problems that i don't understand. why n - i -1.
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j+ 1]) {
                    swap(arr, j, j + 1);
                    flag = true;
                }
            }
            if (!flag) {
                break;
            }
        }
        return arr;
    }

    private void swap(int[] arr, int j, int i) {
        int v = arr[j];
        arr[j] = arr[j+1];
        arr[j+1] = v;
    }


    public static void main(String[] args) {
        Sort sort = new BubbleSort();
        int[] arr = {-1, -100, 100, 200, 68, 97, -45, 13, -27};
        int[] ans = sort.sort(arr, arr.length);
        System.out.println(Arrays.toString(ans));
    }
}
