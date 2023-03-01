package co.com.sofkau.domain.common;

import co.com.sofkau.generic.ValueObject;

public class Price implements ValueObject<Double> {

    private Double price;

    public Price(Double price) {
        this.price = price;
    }

    @Override
    public Double value() {
        return price;
    }
}
