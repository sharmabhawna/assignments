package com.assignments.video_rental;

class Movie {
	static final int CHILDREN = 2;
	static final int  REGULAR = 0;
	static final int  NEW_RELEASE = 1;

	private String title;
	private int priceCode;

	Movie(String title, int priceCode) {
		this.title = title;
		this.priceCode = priceCode;
	}

	void setPriceCode(int price) {
    	priceCode = price;
	}

	String getTitle() {
		return title;
	}

	int rentalPoints(int daysRented) {
		PriceCode priceCode = new PriceCode(this.priceCode);
		return priceCode.calculateRenterPoint(daysRented);
	}

	double rentToPay(int daysRented) {
		PriceCode priceCode = new PriceCode(this.priceCode);
		return priceCode.calculateRent(daysRented);
	}
}

