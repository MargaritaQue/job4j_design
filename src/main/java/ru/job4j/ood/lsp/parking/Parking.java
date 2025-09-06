package ru.job4j.ood.lsp.parking;

import java.util.List;

public interface Parking {

    void add(Car car);

    void delete(Car car);

    Car getByNumber(String number);

    List<Car> getParkingLot();

}
