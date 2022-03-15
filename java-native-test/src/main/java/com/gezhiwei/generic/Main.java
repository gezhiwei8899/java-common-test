package com.gezhiwei.generic;

public class Main {
    public static void main(String[] args) {
        Plate<Fruit> fruitPlate = new Plate<>();
        fruitPlate.set(new Apple());
        fruitPlate.set(new Oringe());
        fruitPlate.set(new Apple());

        Apple apple = fruitPlate.pick(Apple.class);
        System.out.println(apple.getCount());
        Oringe oringe = fruitPlate.pick(Oringe.class);
        System.out.println(oringe.getCount());

    }
}
