package ru.job4j.ood.lsp.parking;

public interface Parking {

    void add(Car car);

    void delete(Car car);

    Car getByNumber(String number);

}
