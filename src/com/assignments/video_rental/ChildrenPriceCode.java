package com.assignments.video_rental;

class ChildrenPriceCode implements PriceCode {

    private static final int leaseDays = 3;
    private static final double rentPerDay = 1.5;
    private double rentalPrice = 1.5;

    @Override
    public double calculateRent(int daysRented) {
        if(daysRented > leaseDays){
            rentalPrice += (daysRented - leaseDays) * rentPerDay;
        }
        return rentalPrice;
    }

    @Override
    public int calculateRenterPoint(int daysRented) {
        return 1;
    }
}
