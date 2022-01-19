package com.gezhiwei.dp;

/**
 * @author gezhiwei
 */
public class FindMaxValueUseLessSpace {


    public int kidnap(int[] items, int[] value, int n, int w) {
        // 定义状态
        int[] state = new int[w + 1];

        // 初始化
        for (int i = 0; i < w + 1; i++) {
            state[i] = -1;
        }
        // 没有这个为什么不对
        // 当没有这个初始状态，state[j]=-1,不会走state[j + items[i]] = state[j] + value[i];
        // 也就是说 state[2]  = state[0] + value[i] 不会初始化
        state[0] = 0;
        state[items[0]] = value[0];

        // 状态转移
        for (int i = 1; i < n; i++) {
            // 把i放入背包
            for (int j = w - items[i]; j >= 0; j--) {
                if (state[j] >= 0) {
                    state[j + items[i]] = state[j] + value[i];
                }
            }

        }

        int maxValue = -1;
        // 结果集
        for (int j = w; j >= 0; j--) {
            if (state[j] > maxValue) {
                maxValue = state[j];
            }
        }
        return maxValue;
    }
}
