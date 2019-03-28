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
        double thisAmount = 0;

        // determine amounts for rental line
        switch (rental.getMovie().getPriceCode()) {
            case Movie.REGULAR:
                thisAmount += 2;
                if (rental.getDaysRented() > 2)
                    thisAmount += (rental.getDaysRented() - 2) * 1.5;
                break;
            case Movie.NEW_RELEASE:
                thisAmount += rental.getDaysRented() * 3;
                break;
            case Movie.CHILDREN:
                thisAmount += 1.5;
                if (rental.getDaysRented() > 3)
                    thisAmount += (rental.getDaysRented() - 3) * 1.5;
                break;

        }
        return thisAmount;
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
            if ((rental.getMovie().getPriceCode() == Movie.NEW_RELEASE)
                    && rental.getDaysRented() > 1)
            latestReleasesCount++;
        }
        return latestReleasesCount;
    }

    String getDescription(){
        StringBuilder description = new StringBuilder();
        for (Rental rental : rentalList) {
            description.append("\t" + rental.getMovie().getTitle() + "\t" + String.valueOf(calculateRentalPrice(rental)) + "\n");
        }
        return description.toString();
    }

    public int getTotalRentals() {
        return rentalList.size();
    }
}
