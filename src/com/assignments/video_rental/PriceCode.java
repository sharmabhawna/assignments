package com.assignments.video_rental;

import java.util.HashMap;
import java.util.Map;

class PriceCode {

    private int price;
    private Map<Integer, PriceCodeTypes> priceCodes;

    PriceCode(int price) {
        this.price = price;
        priceCodes = new HashMap<>(3);
        priceCodes.put(0, PriceCodeTypes.REGULAR);
        priceCodes.put(1, PriceCodeTypes.NEW_RELEASE);
        priceCodes.put(2, PriceCodeTypes.CHILDREN);
    }

    double calculateRent(int daysRented) {
        PriceCodeTypes priceCodeType = priceCodes.get(this.price);
        double rent = 0;

        if(daysRented > priceCodeType.leaseDays){
            rent = (daysRented - priceCodeType.leaseDays) * priceCodeType.rentPerDay;
        }

        return priceCodeType.rentalPrice + rent;
    }

    int calculateRenterPoint(int daysRented) {
        if(this.price == 1 && daysRented > 1){
            return 2;
        }
        return 1;
    }

    private enum PriceCodeTypes {
        CHILDREN(1.5,3,1.5),
        REGULAR(2,2,1.5),
        NEW_RELEASE(0,0,3);

        private final double rentalPrice;
        private final int leaseDays;
        private final double rentPerDay;

         PriceCodeTypes(double rentalPrice, int leaseDays, double rentPerDay) {
            this.rentalPrice = rentalPrice;
            this.leaseDays = leaseDays;
            this.rentPerDay = rentPerDay;
        }
    }

}
