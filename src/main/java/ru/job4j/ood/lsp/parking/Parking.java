package ru.job4j.ood.lsp.parking;

import java.util.List;

public interface Parking {

    void add(Car car);

    void delete(Car car);

    Car getByNumber(String number);

    List<Car> getParkingLot();

    boolean occupyPassengerPlaces(int count);

    boolean occupyTruckPlaces(int count);

    void plusSizeP(int count);

    void plusSizeT(int count);

    int freeLots();
}
