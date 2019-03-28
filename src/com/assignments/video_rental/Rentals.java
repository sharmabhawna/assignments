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

    private double calculateRentalPrice(Rental rental) {
        double rentalPrice = 0;

        switch (rental.getMovie().getPriceCode()) {
            case Movie.REGULAR:
                rentalPrice += 2;
                if (rental.getDaysRented() > 2)
                    rentalPrice += (rental.getDaysRented() - 2) * 1.5;
                break;
            case Movie.NEW_RELEASE:
                rentalPrice += rental.getDaysRented() * 3;
                break;
            case Movie.CHILDREN:
                rentalPrice += 1.5;
                if (rental.getDaysRented() > 3)
                    rentalPrice += (rental.getDaysRented() - 3) * 1.5;
                break;

        }
        return rentalPrice;
    }

    private boolean isNewRelease(Rental rental){
        return rental.getMovie().getPriceCode() == Movie.NEW_RELEASE;
    }

    double calculateTotalRentalPrice() {
        double totalPrice = 0;

        for (Rental rental : rentalList) {
            double rentalPrice = calculateRentalPrice(rental);
            totalPrice += rentalPrice;
        }
        return totalPrice;
    }

    int getLatestReleases() {
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
                    .append(rental.getMovie().getTitle())
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
