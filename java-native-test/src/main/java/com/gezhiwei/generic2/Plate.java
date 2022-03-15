package com.gezhiwei.generic2;

import java.util.ArrayList;
import java.util.List;

public class Plate<T> {

    private T t;

    public Plate(T t) {
        this.t = t;
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }
}
