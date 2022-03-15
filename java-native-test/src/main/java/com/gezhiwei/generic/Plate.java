package com.gezhiwei.generic;

import java.util.ArrayList;
import java.util.List;

public class Plate<T extends Fruit> {

    private List<Fruit> store = new ArrayList<>();

    public void set(T t) {
        for (Fruit fruit : store) {
            if (fruit.getClass().isInstance(t)) {
                fruit.setCount(fruit.getCount() + 1);
                return;
            }
        }
        store.add(t);
        set(t);
    }

    public <T> T pick(Class<T> t) {
        for (Fruit fruit : store) {
            if (t.isInstance(fruit)) {
                return (T) fruit;
            }
        }
        return null;
    }
}
