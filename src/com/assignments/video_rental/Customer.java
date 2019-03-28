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

	private int calculateRentalFrequency() {
        int rentalFrequency = rentals.getTotalRentals();
        int bonusPoints = rentals.getLatestReleaseRentals();
        rentalFrequency = rentalFrequency + bonusPoints;
        return rentalFrequency;
    }

	String statement() {
        StringBuilder result = new StringBuilder();

        result.append("Rental Record for " + getName() + "\n");

        int frequentRenterPoints = calculateRentalFrequency();

       double totalAmount = rentals.calculateTotalRentalPrice();

        String rentalsDescription = rentals.getDescription();

		// add footer lines
        result.append(rentalsDescription);

		result.append("Amount owed is " + totalAmount + "\n");
		result.append("You earned " + frequentRenterPoints + " frequent renter points");
		return result.toString();
	}

}
