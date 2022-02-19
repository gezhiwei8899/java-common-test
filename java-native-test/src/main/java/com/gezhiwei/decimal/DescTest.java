package com.gezhiwei.decimal;

import java.math.BigDecimal;

/**
 * @author gezhiwei
 */
public class DescTest {


    public static void main(String[] args) {
        DescTest descTest = new DescTest();
        descTest.des();
    }

    private String des() {
        BigDecimal bigDecimal = BigDecimal.valueOf(200.12);
        System.out.println(bigDecimal);
        System.out.println(bigDecimal.unscaledValue());
        System.out.println(bigDecimal.scale());
        System.out.println(bigDecimal.signum());
        byte[] bytes = bigDecimal.setScale(4).unscaledValue().toByteArray();

        System.out.println(bytes);
        return "";
    }
}
