package com.gezhiwei.arr;

public class UnitArr {

    int[] a;

    public UnitArr(int[] a){
        this.a = a;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof UnitArr) {
            UnitArr b = (UnitArr) obj;

        }
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
