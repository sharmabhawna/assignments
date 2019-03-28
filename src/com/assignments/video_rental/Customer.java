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

	private String getName() {
		return name;
	}

	private int calculateFrequentRenterPoints() {
        int frequentRenterPoints = 0;
        int bonusPonits = rentals.getLatestReleases();
        int renterPoints = rentals.getTotalRentals();
        frequentRenterPoints = bonusPonits + renterPoints;
        return frequentRenterPoints;
    }

	String statement() {
        StringBuilder result = new StringBuilder();

        result.append("Rental Record for " + getName() + "\n");

        int frequentRenterPoints = calculateFrequentRenterPoints();

       double totalAmount = rentals.calculateTotalRentalPrice();

        String rentalsDescription = rentals.getDescription();

		// add footer lines
        result.append(rentalsDescription);

		result.append("Amount owed is " + String.valueOf(totalAmount) + "\n");
		result.append("You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points");
		return result.toString();
	}

}
