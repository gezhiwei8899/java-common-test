package com.gezhiwei.object.test;

/**
 * @author gezhiwei
 */
public class ObjTest implements Cloneable {

    private int i;

    private ObjTest2 objTest2;

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public ObjTest2 getObjTest2() {
        return objTest2;
    }

    public void setObjTest2(ObjTest2 objTest2) {
        this.objTest2 = objTest2;
    }

    @Override
    public ObjTest clone() {
        try {
            // TODO: 复制此处的可变状态，这样此克隆就不能更改初始克隆的内部
            return (ObjTest) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
