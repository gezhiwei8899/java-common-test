package com.gezhiwei.number;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

public class NumTest {


    @Test
    public void test() {
        int a = 32;
        String x = Integer.toBinaryString(32);
        System.out.println(x);
        String s = Integer.toHexString(32);
        System.out.println(s);
    }

    @Test
    public void test2() {
        int a = 0b11;   //声明二进制变量
        int b = 011;    //声明八进制变量
        int c = 11;     //声明十进制变量
        int d = 0x11;   //声明十六进制变量
        System.out.println("a：" + a); //3
        System.out.println("b：" + b); //9
        System.out.println("c：" + c); //11
        System.out.println("d：" + d); //17
    }

    @Test
    public void test3() {
        int my_num_1 = 6_78_00_120;
        System.out.println("The number is : " + my_num_1);
        long my_num_2 = 2_00_11_001;
        System.out.println("The number is : " + my_num_2);
        float my_num_3 = 4.01_981F;
        System.out.println("The number is : " + my_num_3);
        double my_num_4 = 12.89_46_061;
        System.out.println("The number is : " + my_num_4);
    }


    @Test
    public void test4() {
        long i = 90089L;
//        System.out.println(Long.toBinaryString(i));

        String s = String.valueOf(i);
        System.out.println(s);

        String[] split = s.split("", 1);
        System.out.println(JSONObject.toJSONString(split));

        System.out.println();

        String[] split1 = s.split("", 2);
        System.out.println(JSONObject.toJSONString(split1));

        System.out.println();
        String[] split2 = s.split("");
        System.out.println(JSONObject.toJSONString(split2));
    }

    // 922 3372 0368 5477 5807
    @Test
    public void test5() {
        long i = Long.MAX_VALUE;
        String str = String.valueOf(i);
        System.out.println(str);

        int tSize = 2;
        int p = 3;

        String sub = str.substring(p, p + tSize);
        System.out.println(sub);

        String sub1 = str.substring(p + tSize, p + tSize + tSize);
        System.out.println(sub1);
    }
}
