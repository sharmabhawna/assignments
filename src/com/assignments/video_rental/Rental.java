package com.assignments.video_rental;

class Rental {

    private Movie movie;

    private int daysRented;

    Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    int calculateRentalPoint() {
        return this.movie.rentalPoints(daysRented);
    }

    double calculateRent() {
        return this.movie.rentToPay(daysRented);
    }

    String getStatement() {
        return this.movie.getTitle() + "\t" + this.calculateRent();
    }

}