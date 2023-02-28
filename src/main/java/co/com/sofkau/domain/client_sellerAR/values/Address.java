package co.com.sofkau.domain.client_sellerAR.values;

import co.com.sofkau.generic.ValueObject;

public class Address implements ValueObject<String> {
    private String address;

    public Address(String address) {
        this.address = address;
    }

    @Override
    public String value() {
        return null;
    }
}
