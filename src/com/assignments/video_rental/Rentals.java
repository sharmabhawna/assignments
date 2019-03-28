package com.assignments.video_rental;

import java.util.ArrayList;
import java.util.List;

class Rentals {
    private List<Rental> rentalList;

    Rentals() {
        rentalList = new ArrayList<>();
    }

    void add(Rental rental) {
        rentalList.add(rental);
    }

    private boolean hasMovieOfType(Rental rental, int priceCode) {
        return rental.isMovieOfType(priceCode);
    }

    private double calculateRentalPrice(Rental rental) {
        double rentalPrice = 0;
        int thresholdUnplayableDays = 0;
        double rentPerDay = 1.5;

        if (hasMovieOfType(rental, Movie.REGULAR)) {
            rentalPrice = 2;
            thresholdUnplayableDays = 2;
        }

        if (hasMovieOfType(rental, Movie.CHILDREN)) {
            rentalPrice = 1.5;
            thresholdUnplayableDays = 3;
        }

        if(hasMovieOfType(rental, Movie.NEW_RELEASE)){
            rentPerDay = 3;
        }

        if (rental.isRentedForMoreThan(thresholdUnplayableDays)) {
            rentalPrice += rental.excessiveRentedDays(thresholdUnplayableDays) * rentPerDay;
        }

        return rentalPrice;
    }

    double calculateTotalRentalPrice() {
        double totalPrice = 0;

        for (Rental rental : rentalList) {
            double rentalPrice = calculateRentalPrice(rental);
            totalPrice += rentalPrice;
        }
        return totalPrice;
    }

    int getLatestReleaseRentals() {
        int latestReleasesCount = 0;

        for (Rental rental : rentalList) {
            if (hasMovieOfType(rental, Movie.NEW_RELEASE) && rental.isRentedForMoreThan(1))
                latestReleasesCount++;
        }
        return latestReleasesCount;
    }

    String getDescription() {
        StringBuilder description = new StringBuilder();
        for (Rental rental : rentalList) {
            description.append("\t")
                    .append(rental.getMovieTitle())
                    .append("\t")
                    .append(calculateRentalPrice(rental))
                    .append("\n");
        }
        return description.toString();
    }

    int getTotalRentals() {
        return rentalList.size();
    }
}
