package com.bkravets;

import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Car {
    private double gasLeft;
    private double gasPer100Km;
    private LocalDate lastInspection;

    public boolean isAbleDrive() {
        if(gasLeft < 0) throw new RuntimeException("Gas cannot be less than 0");
        return gasLeft > 0;
    }

    public boolean isApprovedToUse() {
        final int durationBetweenInspections = 2;
        return lastInspection
                .plusYears(durationBetweenInspections)
                .isAfter(LocalDate.now());
    }

    public double distanceCanDrive() {
        if(gasPer100Km <= 0) throw new RuntimeException("Gas consumption should be greater than 0");

        final int distance100Km = 100;
        return (gasLeft / gasPer100Km) * distance100Km;
    }

}
