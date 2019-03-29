package com.assignments.video_rental;

public class NewReleasePriceCode implements PriceCode {

    private static final double rentPerDay = 3;

    @Override
    public double calculateRent(int daysRented) {
        return daysRented * rentPerDay;
    }

    @Override
    public int calculateRenterPoint(int daysRented) {
        if(daysRented > 1){
            return 2;
        }
        return 1;
    }
}
