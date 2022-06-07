package com.gezhiwei.sort.test;

import org.junit.Test;

import java.util.Arrays;

public class QuickSortTest {


    @Test
    public void sort() {

        int[] nums = new int[]{0, -1, 1, 2,-100,98,-1000,2010};
        int len = nums.length;
        quickSort(nums);
        System.out.println(Arrays.toString(Arrays.stream(nums).toArray()));
    }

    private void quickSort(int[] nums) {
        int n = nums.length;
        doQuickSort(nums, 0, n - 1);
    }

    private void doQuickSort(int[] nums, int p, int r) {
        // 终止条件
        if (p >= r) {
            return;
        }
        // 获取分区点
        int q = partition(nums, p, r);
        doQuickSort(nums, p, q - 1);
        doQuickSort(nums, q + 1, r);
    }

    private int partition(int[] nums, int p, int r) {
        int pivot = nums[r];
        int i = p;
        for (int j = p; j <= r - 1; j++) {
            if (pivot > nums[j]) {
                swap(nums, i, j);
                i++;
            }
        }
        swap(nums, i, r);
        return i;
    }

    private void swap(int[] nums, int i, int j) {
        int v = nums[i];
        nums[i] = nums[j];
        nums[j] = v;
    }
}
