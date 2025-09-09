package ru.job4j.ood.lsp.parking;

import java.util.List;

public class ParkingService {
    private final Parking park;

    public ParkingService(Parking park) {
        this.park = park;
    }

    public boolean park(Car car) {
        if (car.getSize() == 1) {
            if (park.occupyPassengerPlaces(1)) {
                park.add(car);
                return true;
            }
        } else {
            if (park.occupyTruckPlaces(1)) {
                park.add(car);
                return true;
            } else if (park.occupyPassengerPlaces(car.getSize())) {
                park.add(car);
                return true;
            }
        }
        return false;
    }

    public Car unpark(String number) {
        Car car = park.getByNumber(number);
        if (car == null) {
            throw new IllegalArgumentException();
        }
        if (car.getSize() == 1) {
            park.plusSizeP(1);
        } else {
            park.plusSizeT(1);
        }
        park.delete(car);
        return car;
    }

    public boolean check(String number) {
        return park.getByNumber(number) != null;
    }

    public int freeLots() {
        return park.freeLots();
    }

    public List<Car> report() {
        return park.getParkingLot();
    }
}
