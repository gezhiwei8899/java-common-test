package com.gezhiwei.sort.test;

import com.alibaba.fastjson.JSONObject;
import org.junit.Before;
import org.junit.Test;

public class MergeSort {

    private int[] arr;

    private int count = 1;

    @Before
    public void before() {
        arr = new int[]{2, 4, 8, 3, 5, 2, 8, 6, 7};
    }

    /**
     * 归并排序，分治递归排序
     */
    @Test
    public void mergeSortTest() {
        if (arr == null) {
            return;
        }
        int size = arr.length;
        System.out.println(JSONObject.toJSONString(arr));
        mergeSort(arr, size);
    }

    private void mergeSort(int[] arr, int n) {

        int[] ints = doMergeSort(arr);
        System.out.println();
        System.out.println("origin: " + JSONObject.toJSONString(arr));
        System.out.println("final: " + JSONObject.toJSONString(ints));
    }

    private int[] doMergeSort(int[] arr) {
        // 递归终止条件
        if (arr.length == 1) {
            return arr;
        }

        int r = arr.length;
        int q = arr.length / 2;
        int[] a = new int[q];
        System.arraycopy(arr, 0, a, 0, q);
        System.out.println(count + "a: " + JSONObject.toJSONString(a));


        int[] b = new int[r - q];
        System.arraycopy(arr, q, b, 0, r - q);
        System.out.println(count + "b: " + JSONObject.toJSONString(b));

        count++;

        a = doMergeSort(a);
        b = doMergeSort(b);
        return merge(a, b);
    }

    private int[] merge(int[] a, int[] b) {
        int la = a.length;
        int lb = b.length;

        int[] tmp = new int[la + lb];

        int i = 0, j = 0, t = 0;

        while (i < la && j < lb) {
            if (a[i] < b[j]) {
                tmp[t++] = a[i++];
            } else {
                tmp[t++] = b[j++];
            }
        }

        if (i < la) {
            while (i < la) {
                tmp[t++] = a[i++];
            }
        }

        if (j < lb) {
            while (j < lb) {
                tmp[t++] = b[j++];
            }
        }
        System.out.println(count + "merge: " + JSONObject.toJSONString(a) + " with " + JSONObject.toJSONString(b));
        System.out.println(count + "tmp: " + JSONObject.toJSONString(tmp));
        return tmp;
    }
}
