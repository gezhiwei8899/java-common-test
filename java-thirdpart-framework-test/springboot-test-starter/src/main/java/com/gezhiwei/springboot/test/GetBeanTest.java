package com.gezhiwei.springboot.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class GetBeanTest {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();

        GetBeanTest bean = annotationConfigApplicationContext.getBean(GetBeanTest.class);
    }
}
