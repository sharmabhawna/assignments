package com.assignments.video_rental;

public class PriceCode {

    private final int basePrice;
    private final int baseDays;
    private final double rentalPrice;

    public PriceCode(int basePrice, int baseDays, double rentalPrice) {
        this.basePrice = basePrice;
        this.baseDays = baseDays;
        this.rentalPrice = rentalPrice;
    }
}
