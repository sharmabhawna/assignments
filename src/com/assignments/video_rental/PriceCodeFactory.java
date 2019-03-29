package com.assignments.video_rental;

import java.util.HashMap;
import java.util.Map;

class PriceCodeFactory {

    private int price;
    private Map<Integer, PriceCode> priceCodes;

    PriceCodeFactory(int price) {
        this.price = price;
        priceCodes = new HashMap<>(3);
        priceCodes.put(0, new RegularPriceCode());
        priceCodes.put(1, new NewReleasePriceCode());
        priceCodes.put(2, new ChildrenPriceCode());
    }

     PriceCode getPriceCode(){
        return priceCodes.get(price);
    }

}
