package com.gezhiwei.alt.run.back.test;

import org.junit.Test;

public class EightQueues {

    int[] result = new int[8];

    int count;

    @Test
    public void test() {
        cal8Queues(0);
        System.out.println(count);
    }

    public void cal8Queues(int row) {
        // 终止条件
        if (row == 8) {
            count++;
            printQueens(result);
            return;
        }
        // 每一行有8个格子可以放置棋子
        for (int col = 0; col < 8; col++) {
            // 如果满足，就放置下一行
            if (isOk(row, col)) {
                result[row] = col;
                cal8Queues(row + 1);
            }
        }
    }

    private boolean isOk(int row, int col) {
        int leftup = col - 1;
        int rightup = col + 1;
        // 逐行考察上一行
        for (int i = row - 1; i >= 0; i--) {
            // 列
            if (result[i] == col) {
                return false;
            }
            // 左上
            if (leftup >= 0) {
                if (result[i] == leftup) {
                    return false;
                }
            }
            // 又上
            if (rightup < 8) {
                if (result[i] == rightup) {
                    return false;
                }
            }
            //Ps： 按层放置，同层不用考虑。

            --leftup;
            ++rightup;
        }

        return true;
    }

    private void printQueens(int[] result) {
        // 打印出一个二维矩阵
        for (int row = 0; row < 8; ++row) {
            for (int column = 0; column < 8; ++column) {
                if (result[row] == column) System.out.print("Q ");
                else System.out.print("* ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
