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
    public boolean occupyPassengerPlaces(int count) {
        if (placesP >= count) {
            placesP -= count;
            return true;
        }
        return false;
    }

    @Override
    public boolean occupyTruckPlaces(int count) {
        if (placesT >= count) {
            placesT -= count;
            return true;
        }
        return false;
    }

    @Override
    public void plusSizeP(int count) {
        placesP += count;
    }

    @Override
    public void plusSizeT(int count) {
        placesT += count;
    }

    @Override
    public int freeLots() {
        return placesT + placesP;
    }

    @Override
    public void add(Car car) {
        parkingLot.add(car);
    }

    @Override
    public void delete(Car car) {
        parkingLot.remove(car);
    }

    @Override
    public Car getByNumber(String number) {
        return parkingLot.stream()
                .filter(car -> number.equals(car.getNumber()))
                .findFirst().orElse(null);
    }

}
