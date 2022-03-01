package com.gezhiwei.father;

public class ChildClazz extends FatherClass {

    public ChildClazz() {
        super(1);
    }

    public static void main(String[] args) {
        ChildClazz childClazz = new ChildClazz();
        childClazz.test();
    }

    public void test() {
        System.out.println("test");
    }
}
