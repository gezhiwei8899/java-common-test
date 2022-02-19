package com.gezhiwei.sort.test;

import com.alibaba.fastjson.JSONObject;
import org.junit.Before;
import org.junit.Test;

public class QuickSort {

    private int[] arr;

    private int count = 1;

    @Before
    public void before() {
        arr = new int[]{2, 4, 8, 3, 5, 2, 8, 6, 7};
    }

    @Test
    public void quickSortTest() {
        if (arr == null || arr.length == 1) {
            return;
        }

        int n = arr.length;
        System.out.println(JSONObject.toJSONString(arr));
        quickSort(arr, n);
    }

    private void quickSort(int[] arr, int n) {
        doQuickSort(arr, 0, n - 1);
    }

    /**
     * 递归函数
     *
     * @param arr 数组
     * @param p   index
     * @param r   end
     */
    private void doQuickSort(int[] arr, int p, int r) {

        if (p >= r) {
            return;
        }

        int q = partition(arr, p, r);
        System.out.println(count + "q: " + q + "  and value: " + arr[q]);
        count++;

        doQuickSort(arr, p, q - 1);
        doQuickSort(arr, q + 1, r);
    }

    /**
     * 核心函数 分区函数
     *
     * @param arr 数组
     * @param p   排序区间的开始位置
     * @param r   排序区间的结束位置
     * @return 分区下标
     */
    private int partition(int[] arr, int p, int r) {
        int pivot = arr[r];
        int i = p;
        for (int j = p; j <= r - 1; j++) {
            if (arr[j] < pivot) {
                swap(arr, i, j);
                i++;
            }
            System.out.println(count + "arr: " + JSONObject.toJSONString(arr));
        }
        swap(arr, i, r);
        System.out.println(count + "final swap arr: " + JSONObject.toJSONString(arr));
        return i;
    }

    /**
     * 交换函数
     *
     * @param arr 数组
     * @param i   下标
     * @param j   下标
     */
    private void swap(int[] arr, int i, int j) {
        int c = arr[i];
        arr[i] = arr[j];
        arr[j] = c;
    }
}
