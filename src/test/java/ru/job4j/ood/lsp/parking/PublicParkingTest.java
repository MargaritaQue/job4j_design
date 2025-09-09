package ru.job4j.ood.lsp.parking;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PublicParkingTest {

    @Test
    void add() {
        PublicParking park = new PublicParking(3, 3);
        Car carL = new PassengerCar("a321dd");
        Car carT = new Truck(3, "v123vv");
        park.add(carL);
        park.add(carT);
        List<Car> expectedCars = List.of(
                carL,
                carT
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
    void occupyPassengerPlacesTrue() {
        PublicParking park = new PublicParking(1, 3);
        int count = 1;
        assertTrue(park.occupyPassengerPlaces(count));
    }

    @Test
    void occupyPassengerPlacesFalse() {
        PublicParking park = new PublicParking(1, 3);
        int count = 2;
        assertFalse(park.occupyPassengerPlaces(count));
    }

    @Test
    void occupyTruckPlacesTrue() {
        PublicParking park = new PublicParking(1, 3);
        int count = 1;
        assertTrue(park.occupyPassengerPlaces(count));
    }

    @Test
    void occupyTruckPlacesFalse() {
        PublicParking park = new PublicParking(1, 3);
        int count = 4;
        assertFalse(park.occupyPassengerPlaces(count));
    }

    @Test
    void delete() {
        PublicParking park = new PublicParking(3, 3);
        Car carL = new PassengerCar("a321dd");
        Car carT = new Truck(3, "v123vv");
        park.add(carL);
        park.add(carT);
        park.delete(carT);
        List<Car> expectedCars = List.of(
                carL
        );
        assertEquals(expectedCars, park.getParkingLot());
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

}