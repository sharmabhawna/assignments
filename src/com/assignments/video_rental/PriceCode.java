package com.assignments.video_rental;

interface PriceCode {

    double calculateRent(int daysRented);

    int calculateRenterPoint(int daysRented);
}
