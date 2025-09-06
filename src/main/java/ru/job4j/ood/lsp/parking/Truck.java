package ru.job4j.ood.lsp.parking;

public class Truck extends Car {
    public Truck(int size, String number) {
        super(size, number);
    }

    @Override
    boolean valid(int size) {
        return false;
    }
}
