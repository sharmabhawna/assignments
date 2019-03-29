package com.assignments.video_rental;

class Customer {

    private String name;
    private Rentals rentals;

    Customer(String name) {
        this.name = name;
        this.rentals = new Rentals();
    }

    void addRental(Rental rental) {
        rentals.add(rental);
    }

    String statement() {
        StringBuilder result = new StringBuilder();

        result.append("Rental Record for " + this.name + "\n");

        int frequentRenterPoints = rentals.calculateRentalFrequency();

        double totalRentalPrice = rentals.calculateTotalRent();

        String rentalsDescription = rentals.getStatement();

        // add footer lines
        result.append(rentalsDescription);

        result.append("Amount owed is " + totalRentalPrice + "\n");
        result.append("You earned " + frequentRenterPoints + " frequent renter points");
        return result.toString();
    }

}
