package co.com.sofkau.domain.saleAR.values;

import co.com.sofkau.generic.ValueObject;

import java.time.LocalDateTime;

public class ShippingTime implements ValueObject<LocalDateTime> {

    private LocalDateTime shippingTime;

    public ShippingTime(LocalDateTime shippingTime) {
        this.shippingTime = shippingTime;
    }

    @Override
    public LocalDateTime value() {
        return shippingTime;
    }
}
