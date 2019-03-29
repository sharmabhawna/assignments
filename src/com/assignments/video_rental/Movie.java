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
		if(this.priceCode == Movie.NEW_RELEASE && daysRented > 1){
			return 2;
		}
		return 1;
	}

	double rentToPay(int daysRented) {
		double rentalPrice = 0;
		int leaseDays = 0;
		double rentPerDay = 1.5;

		if (this.priceCode == Movie.REGULAR) {
			rentalPrice = 2;
			leaseDays = 2;
		}

		if (this.priceCode == Movie.CHILDREN) {
			rentalPrice = 1.5;
			leaseDays = 3;
		}

		if (this.priceCode == Movie.NEW_RELEASE) {
			rentPerDay = 3;
		}

		int excessiveDays = daysRented - leaseDays;

		if (daysRented > leaseDays) {
			rentalPrice +=  excessiveDays * rentPerDay;
		}

		return rentalPrice;
	}
}

