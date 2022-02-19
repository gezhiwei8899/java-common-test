package com.gezhiwei.dp;

/**
 * @author gezhiwei
 */
public class FindMaxValue {


    /**
     * 背包
     *
     * @param items 质量
     * @param value 价值
     * @param n     个数
     * @param w     背包总质量限制
     */
    public int kidnap(int[] items, int[] value, int n, int w) {
        // 总价值
        int result = 0;
        // 定义状态
        int[][] state = new int[n][w + 1];
        // 初始化数据,todo 为什么？
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < w + 1; j++) {
                // 为什么要定义这个？
                state[i][j] = -1;
            }
        }

        state[0][0] = 0;
        if (items[0] <= w) {
            state[0][items[0]] = value[0];
        }


        // 状态转移
        for (int i = 1; i < n; i++) {
            // 不把物品i放入背包
            for (int j = 0; j <= w - items[i]; j++) {
                // 这里判断个寂寞？小于0有关系吗？
                // 遍历上一层的状态，-1的没有必要拿出来赋值了，结果都一样，那些状态集里不为-1的，肯定是多个上层的结果集
                if (state[i - 1][j] >= 0) {
                    // 此时背包总价值总是和上一个状态相等
                    state[i][j] = state[i - 1][j];
                }
            }

            // 把i放入背包
            for (int j = 0; j <= w - items[i]; j++) {
                if (state[i - 1][j] >= 0) {
                    // 把i放入背包的价值大背包当前的价值的话，那就放
                    int v = state[i - 1][j] + value[i];
                    if (v > state[i][j + items[i]]) {
                        state[i][j+items[i]] = v;
                    }
                }
            }
        }

        for (int j = w; j > 0; j--) {
            // 最后一行是所有历史结果集合
            if (state[n - 1][j] > result) {
                result = state[n - 1][j];
            }
        }
        return result;

    }
}
