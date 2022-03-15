package com.gezhiwei.generic2;

public class Main {
    public static void main(String[] args) {
        Plate<? extends Fruit> fruitPlate = new Plate<>(new Apple());
//        fruitPlate.setT(new Apple());
//        fruitPlate.setT(new Oringe());
//        fruitPlate.setT(new Apple());

        System.out.println(fruitPlate.getT());
        System.out.println(fruitPlate.getT());

    }
}
