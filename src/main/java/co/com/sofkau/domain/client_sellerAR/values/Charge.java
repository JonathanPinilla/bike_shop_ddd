package co.com.sofkau.domain.client_sellerAR.values;

import co.com.sofkau.generic.ValueObject;

public class Charge implements ValueObject<String> {
    private String charge;

    public Charge(String charge) {
        this.charge = charge;
    }

    @Override
    public String value() {
        return charge;
    }
}
