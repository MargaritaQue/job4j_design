package ru.job4j.ood.isp;

public class Dog implements Animal {
    @Override
    public void eat() {
        System.out.println("Dog eats.");
    }

    @Override
    public void fly() {
        throw new UnsupportedOperationException("Dog cannot fly");
    }

    @Override
    public void swim() {
        System.out.println("Dog swims.");
    }

}
