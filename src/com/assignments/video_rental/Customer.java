package com.assignments.video_rental;

import java.util.ArrayList;

class Customer {

	private String name;
	private ArrayList<Rental> rentalList = new ArrayList<Rental>();

	Customer(String name) {
		this.name = name;
	}

	void addRental(Rental arg) {
		rentalList.add(arg);
	}

	private String getName() {
		return name;
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

	String statement() {
		double totalAmount = 0;
		int frequentRenterPoints = 0;
		String result = "Rental Record for " + getName() + "\n";
		for (Rental rental : rentalList) {
			double rentalPrice = calculateRentalPrice(rental);

			// add frequent renter points
			frequentRenterPoints++;
			// add bonus for a two day new release rental
			if ((rental.getMovie().getPriceCode() == Movie.NEW_RELEASE)
					&& rental.getDaysRented() > 1)
				frequentRenterPoints++;

			// show figures for this rental
			result += "\t" + rental.getMovie().getTitle() + "\t"
					+ String.valueOf(rentalPrice) + "\n";
			totalAmount += rentalPrice;

		}
		// add footer lines
		result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
		result += "You earned " + String.valueOf(frequentRenterPoints)
				+ " frequent renter points";
		return result;
	}

}
