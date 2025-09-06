package ru.job4j.ood.lsp.parking;

import java.util.List;

public class ParkingService {
    private final Parking park;

    public ParkingService(Parking park) {
        this.park = park;
    }

    public boolean park(Car car) {
        return false;
    }

    public Car unpark(String number) {
        return null;
    }

    public boolean check(String number) {
        return false;
    }

    public int freeLots() {
        return 0;
    }

    public List<Car> report() {
        return park.getParkingLot();
    }
}
