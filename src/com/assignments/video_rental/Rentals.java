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

    private boolean hasMovieOfType(Rental rental, int priceCode){
        return rental.isMovieOfType(priceCode);
    }

    private double calculateRentalPrice(Rental rental) {
        double rentalPrice = 0;

        if (hasMovieOfType(rental, Movie.REGULAR)) {
            rentalPrice += 2;
            if (rental.getDaysRented() > 2)
                rentalPrice += (rental.getDaysRented() - 2) * 1.5;
        }

        if (hasMovieOfType(rental, Movie.NEW_RELEASE)) {
            rentalPrice += rental.getDaysRented() * 3;
        }

        if (hasMovieOfType(rental, Movie.CHILDREN)) {
            rentalPrice += 1.5;
            if (rental.getDaysRented() > 3)
                rentalPrice += (rental.getDaysRented() - 3) * 1.5;
        }

        return rentalPrice;
    }

    private boolean isNewRelease(Rental rental) {
        return rental.isMovieOfType(Movie.NEW_RELEASE);
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
            if (isNewRelease(rental) && rental.getDaysRented() > 1)
                latestReleasesCount++;
        }
        return latestReleasesCount;
    }

    String getDescription() {
        StringBuilder description = new StringBuilder();
        for (Rental rental : rentalList) {
            description.append("\t")
                    .append(rental.getDescription())
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
