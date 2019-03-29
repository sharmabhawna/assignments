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

    double calculateTotalRent() {
        double totalPrice = 0;

        for (Rental rental : rentalList) {
            double rentalPrice = rental.calculateRent();
            totalPrice += rentalPrice;
        }
        return totalPrice;
    }

    int calculateTotalPoints() {
        int renterPoints = 0;
        for (Rental rental : rentalList) {
            renterPoints += rental.calculatePoint();
        }
        return renterPoints;
    }

    String getDescription() {
        StringBuilder description = new StringBuilder();
        for (Rental rental : rentalList) {
            description.append("\t")
                    .append(rental.getMovieTitle())
                    .append("\t")
                    .append(rental.calculateRent())
                    .append("\n");
        }
        return description.toString();
    }
}
