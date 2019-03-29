package com.assignments.video_rental;

class Rental {

    private Movie movie;

    private int daysRented;

    Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    String getMovieTitle() {
        return this.movie.getTitle();
    }

    private boolean isMovieOfType(int priceCode) {
        return this.movie.isSameMovie(priceCode);
    }

    private boolean isRentedForMoreThan(int days) {
        return this.daysRented > days;
    }

    private int excessiveDays(int thresholdUnplayableDays) {
        return this.daysRented - thresholdUnplayableDays;
    }

    int calculatePoint() {
        return this.movie.renterPoints(daysRented);
    }

    double calculateRent() {
        double basePrice = 0;
        int baseDays = 0;
        double rentalPrice = 1.5;

        if (isMovieOfType(Movie.REGULAR)) {
            basePrice = 2;
            baseDays = 2;
        }

        if (isMovieOfType(Movie.CHILDREN)) {
            basePrice = 1.5;
            baseDays = 3;
        }

        if (isMovieOfType(Movie.NEW_RELEASE)) {
            rentalPrice = 3;
        }

        if (isRentedForMoreThan(baseDays)) {
            basePrice += excessiveDays(baseDays) * rentalPrice;
        }

        return basePrice;

    }
}