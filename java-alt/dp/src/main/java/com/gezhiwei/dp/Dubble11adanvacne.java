package com.gezhiwei.dp;

public class Dubble11adanvacne {

    /**
     * 限定每个价格商品只能买一件
     *
     * @param items 商品价格
     * @param n     商品个数
     * @param w     满减条件
     */
    public static void double11advance(int[] items, int n, int w) {
        // 定义状态
        // 根据注释说 超过三倍就没有价值了
        boolean[][] state = new boolean[n][3 * w + 1];

        // 初始化数据
        // boolean 默认都是false
        // 边界值
        state[0][0] = true;
        if (items[0] < 3 * w) {
            state[0][items[0]] = true;
        }

        // 状态转移
        for (int i = 1; i < n; i++) {
            // 不放入购物车的
            for (int j = 0; j <= 3 * w; j++) {
                if (state[i - 1][j]) {
                    state[i][j] = state[i - 1][j];
                }
            }

            for (int j = 0; j <= 3 * w - items[i]; j++) {
                if (state[i - 1][j]) {
                    state[i][j] = state[i][j + items[i]];
                }
            }
        }

        // 结果集

    }

}
