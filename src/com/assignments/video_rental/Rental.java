package com.assignments.video_rental;

class Rental {

    private Movie movie;

    private int daysRented;

    Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    String getMovieTitle(){
        return this.movie.getTitle();
    }

    boolean isMovieOfType(int priceCode){
        return this.movie.isSameMovie(priceCode);
    }

    boolean isRentedForMoreThan(int days) {
        return this.daysRented > days;
    }

    int excessiveRentedDays(int thresholdUnplayableDays) {
        return this.daysRented - thresholdUnplayableDays;
    }
}