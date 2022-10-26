package com.bkravets;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    @Test
    void shouldAbleToDrive() {
        Car car = new Car(40, 5, LocalDate.now().minusYears(1));

        boolean ableDrive = car.isAbleDrive();

        assertTrue(ableDrive);
    }

    @Test
    void shouldNotBeAbleToDrive() {
        Car car = new Car(0, 5, LocalDate.now().minusYears(1));

        boolean ableDrive = car.isAbleDrive();

        assertFalse(ableDrive);
    }

    @Test
    void shouldNotAbleDriveThrowException() {
        Car car = new Car(-1, 5, LocalDate.now().minusYears(1));


        RuntimeException exception = assertThrows(RuntimeException.class, car::isAbleDrive);

        assertEquals("Gas cannot be less than 0", exception.getMessage());
    }

    @Test
    void shouldBeApprovedToUse() {
        Car car = new Car(40, 5, LocalDate.now().minusYears(1));

        boolean approvedToUse = car.isApprovedToUse();

        assertTrue(approvedToUse);
    }

    @Test
    void shouldNotBeApprovedToUse() {
        Car car = new Car(40, 5, LocalDate.now().minusYears(3));

        boolean approvedToUse = car.isApprovedToUse();

        assertFalse(approvedToUse);
    }



    @Test
    void distanceCanDrive() {
        Car car = new Car(40, 5, LocalDate.now().minusYears(1));

        double distance = car.distanceCanDrive();

        assertEquals(800.0, distance, 0.00001);

    }


    @Test
    void distanceCanDriveWhenNoGas() {
        Car car = new Car(0, 5, LocalDate.now().minusYears(1));

        double distance = car.distanceCanDrive();

        assertEquals(0, distance);

    }

    @Test
    void distanceCanDriveThrowException() {
        Car car = new Car(40, 0, LocalDate.now().minusYears(1));


        RuntimeException exception = assertThrows(RuntimeException.class, car::distanceCanDrive);
        assertEquals("Gas consumption should be greater than 0", exception.getMessage());
    }
}