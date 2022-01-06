package com.gezhiwei.object.test;

import org.openjdk.jol.info.ClassLayout;

/**
 * @author gezhiwei
 */
public class JolTest {


    public static void main(String[] args) {
        ObjTest jolTest = new ObjTest();
        jolTest.setI(-1);
        ObjTest2 objTest2 = new ObjTest2();
        objTest2.setI(111);
        jolTest.setObjTest2(objTest2);
        String json = ClassLayout.parseInstance(jolTest).toPrintable();
        System.out.println(json);

        ObjTest clone = jolTest.clone();
        synchronized (clone) {
            String cloneS = ClassLayout.parseInstance(clone).toPrintable();
            System.out.println(cloneS);
        }
    }
}
