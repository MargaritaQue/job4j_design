package ru.job4j.ood.lsp.parking;

import java.util.ArrayList;
import java.util.List;

public class PublicParking implements Parking {
    private List<Car> parkingLot = new ArrayList<>();
    private int placesP;
    private int placesT;

    public PublicParking(int placesP, int placesT) {
        this.placesP = placesP;
        this.placesT = placesT;
    }

    @Override
    public List<Car> getParkingLot() {
        return parkingLot;
    }

    @Override
    public void add(Car car) {
        parkingLot.add(car);
    }

    @Override
    public void delete(Car car) {

    }

    @Override
    public Car getByNumber(String number) {
        return null;
    }

}
