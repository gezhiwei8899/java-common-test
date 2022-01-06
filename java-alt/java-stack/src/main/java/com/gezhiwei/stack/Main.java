package com.gezhiwei.stack;

import java.util.Stack;

public class Main {


    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(5);
        stack.push(6);

        for (Integer integer : stack) {
            System.out.println(integer);
        }



        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }

        Integer peek = stack.peek();
    }
}
