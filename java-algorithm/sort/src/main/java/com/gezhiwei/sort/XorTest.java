package com.gezhiwei.sort;

public class XorTest {

    public static void main(String[] args) {
        int a = 8, b = 10, c = 5;

        if(a > b) {
            a = a ^ b;
            b = a ^ b;
            a = a ^ b;
        }
        if( b > c) {
            b = b ^ c;
            c = b ^ c;
            b = b ^ c;
        }
        if(a > b) {
            a = a ^ b;
            b = a ^ b;
            a = a ^ b;
        }
        System.out.println("a: " + a);
        System.out.println("b: " + b);
        System.out.println("c: " + c);
    }
}
