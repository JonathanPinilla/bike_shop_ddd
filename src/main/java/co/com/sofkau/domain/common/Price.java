package co.com.sofkau.domain.common;

import co.com.sofkau.generic.ValueObject;

public class Price implements ValueObject<Integer> {

    private int price;

    public Price(int price) {
        this.price = price;
    }

    @Override
    public Integer value() {
        return price;
    }
}
