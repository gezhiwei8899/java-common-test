package com.gezhiwei;

public class GCD {


    public static void main(String[] args) {
        GCD gcd = new GCD();
//        int gcd1 = gcd.gcd(10, 8);
        int gcd1 = gcd.gcd(8, 10);
        System.out.println(gcd1);
    }

    public int gcd(int x, int y) {
        return y == 0 ? x : gcd(y, x % y);
    }
}
