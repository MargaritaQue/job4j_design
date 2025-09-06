package ru.job4j.ood.lsp.parking;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

@Disabled
class ParkingServiceTest {

    @Test
    void parkTrue() {
        PublicParking park = new PublicParking(3, 3);
        Car carL = new PassengerCar("a321dd");
        Car carT = new Truck(3, "v123vv");
        park.add(carL);
        park.add(carT);
        ParkingService service = new ParkingService(park);
        assertTrue(service.park(new PassengerCar("s122hh")));
        assertEquals(3, service.freeLots());
    }

    @Test
    void parkTruckTrue() {
        PublicParking park = new PublicParking(3, 1);
        Car carL = new PassengerCar("a321dd");
        Car carT = new Truck(3, "v123vv");
        park.add(carL);
        park.add(carT);
        ParkingService service = new ParkingService(park);
        assertTrue(service.park(new Truck(2,"s122hh")));
        assertEquals(0, service.freeLots());
    }

    @Test
    void parkFalse() {
        PublicParking park = new PublicParking(1, 3);
        Car carL = new PassengerCar("a321dd");
        Car carT = new Truck(3, "v123vv");
        park.add(carL);
        park.add(carT);
        ParkingService service = new ParkingService(park);
        assertFalse(service.park(new PassengerCar("s122hh")));
        assertEquals(2, service.freeLots());
    }

    @Test
    void unparkTrue() {
        PublicParking park = new PublicParking(3, 4);
        Car carL = new PassengerCar("a321dd");
        Car carT = new Truck(3, "v123vv");
        park.add(carL);
        park.add(carT);
        ParkingService service = new ParkingService(park);
        assertEquals(carL, service.unpark("a321dd"));
        assertEquals(6, service.freeLots());
    }

    @Test
    void unparkFalse() {
        PublicParking park = new PublicParking(3, 4);
        Car carL = new PassengerCar("a321dd");
        Car carT = new Truck(3, "v123vv");
        park.add(carL);
        park.add(carT);
        ParkingService service = new ParkingService(park);
        assertThrows(NoSuchElementException.class, () -> {
            service.unpark("f444ggh");
        });
    }

    @Test
    void checkTrue() {
        PublicParking park = new PublicParking(3, 4);
        Car carL = new PassengerCar("a321dd");
        Car carT = new Truck(3, "v123vv");
        park.add(carL);
        park.add(carT);
        ParkingService service = new ParkingService(park);
        assertTrue(service.check("a321dd"));
    }

    @Test
    void checkFalse() {
        PublicParking park = new PublicParking(3, 4);
        Car carL = new PassengerCar("a321dd");
        Car carT = new Truck(3, "v123vv");
        park.add(carL);
        park.add(carT);
        ParkingService service = new ParkingService(park);
        assertFalse(service.check("a333ff"));
    }

    @Test
    void freeLots() {
        PublicParking park = new PublicParking(3, 4);
        Car carL = new PassengerCar("a321dd");
        Car carT = new Truck(3, "v123vv");
        park.add(carL);
        park.add(carT);
        ParkingService service = new ParkingService(park);
        int expectedLots = 5;
        assertEquals(expectedLots, service.freeLots());
    }

    @Test
    void report() {
        PublicParking park = new PublicParking(3, 4);
        Car carL = new PassengerCar("a321dd");
        Car carT = new Truck(3, "v123vv");
        park.add(carL);
        park.add(carT);
        ParkingService service = new ParkingService(park);
        List<Car> expectedCars = List.of(
                new PassengerCar("a321dd"),
                new Truck(3, "v123vv")
        );
        assertEquals(expectedCars, service.report());
    }
}