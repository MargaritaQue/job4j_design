package ru.job4j.ood.lsp.parking;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@Disabled
class PublicParkingTest {

    @Test
    void add() {
        PublicParking park = new PublicParking(3, 3);
        Car carL = new PassengerCar("a321dd");
        Car carT = new Truck(3, "v123vv");
        park.add(carL);
        park.add(carT);
        List<Car> expectedCars = List.of(
                new PassengerCar("a321dd"),
                new Truck(3, "v123vv")
        );
        assertEquals(expectedCars, park.getParkingLot());
    }

    @Test
    void addCarException() {
        PublicParking park = new PublicParking(3, 3);
        Car carL = new PassengerCar("a321dd");
        assertThrows(IllegalArgumentException.class, () -> {
            Car carT = new Truck(1, "v123vv");
        });
    }

    @Test
    void addNoVacanciesForPassengerCar() {
        PublicParking park = new PublicParking(1, 3);
        Car carL = new PassengerCar("a321dd");
        Car carT = new Truck(3, "v123vv");
        Car carL2 = new PassengerCar("a444dd");
        park.add(carL);
        park.add(carT);
        assertThrows(IllegalStateException.class, () -> {
            park.add(carL2);
        });
    }

    @Test
    void addNoVacanciesForTruck() {
        PublicParking park = new PublicParking(1, 3);
        Car carL = new PassengerCar("a321dd");
        Car carT = new Truck(3, "v123vv");
        Car carT2 = new Truck(3, "a444dd");
        park.add(carL);
        park.add(carT);
        assertThrows(IllegalStateException.class, () -> {
            park.add(carT2);
        });
    }

    @Test
    void delete() {
        PublicParking park = new PublicParking(3, 3);
        Car carL = new PassengerCar("a321dd");
        Car carT = new Truck(3, "v123vv");
        park.add(carL);
        park.delete(carT);
        List<Car> expectedCars = List.of(
                new PassengerCar("a321dd")
        );
        assertEquals(expectedCars, park.getParkingLot());
    }

    @Test
    void deleteException() {
        PublicParking park = new PublicParking(3, 3);
        Car carL = new PassengerCar("a321dd");
        Car carT = new Truck(3, "v123vv");
        park.add(carL);
        park.add(carT);
        assertThrows(NoSuchElementException.class, () -> {
            park.delete(new Truck(3, "f444ggh"));
        });
    }

    @Test
    void getByNumber() {
        PublicParking park = new PublicParking(3, 3);
        Car carL = new PassengerCar("a321dd");
        Car carT = new Truck(3, "v123vv");
        park.add(carL);
        park.add(carT);
        assertEquals(carL, park.getByNumber("a321dd"));
    }

    @Test
    void getByNumberException() {
        PublicParking park = new PublicParking(3, 3);
        Car carL = new PassengerCar("a321dd");
        Car carT = new Truck(3, "v123vv");
        park.add(carL);
        park.add(carT);
        assertThrows(NoSuchElementException.class, () -> {
            park.getByNumber("f444fff");
        });
    }
}