package com.assignments.video_rental;

class Rental {

    private Movie movie;

    private int daysRented;

    Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    int getDaysRented() {
        return daysRented;
    }

    Movie getMovie() {
        return movie;
    }
}