package ru.job4j.ood.lsp.parking;

public class PassengerCar extends Car {

    public PassengerCar(String number) {
        super(1, number);
    }

    @Override
    boolean valid(int size) {
        return true;
    }
}
