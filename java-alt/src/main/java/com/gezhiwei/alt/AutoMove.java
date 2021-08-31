package com.gezhiwei.alt;

/**
 * @author gezhiwei
 */
public class AutoMove {

    public static void main(String[] args) {
        AutoMove autoMove = new AutoMove();
        int n = autoMove.getN(4);
        System.out.println(n);
    }

    public int getN(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        return getN(n - 1) + getN(n - 2);
    }
}
