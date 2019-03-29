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

    int calculateRentalFrequency() {
        int renterPoints = 0;
        for (Rental rental : rentalList) {
            renterPoints += rental.calculateRentalPoint();
        }
        return renterPoints;
    }

    String getStatement() {
        StringBuilder description = new StringBuilder();

        for (Rental rental : rentalList) {
            description.append("\t")
                    .append(rental.getStatement())
                    .append("\n");
        }

        return description.toString();
    }
}
