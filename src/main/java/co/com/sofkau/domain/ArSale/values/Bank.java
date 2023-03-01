package co.com.sofkau.domain.ArSale.values;

import co.com.sofkau.generic.ValueObject;

public class Bank implements ValueObject<String> {
    private String bank;

    public Bank(String bank) {
        this.bank = bank;
    }

    @Override
    public String value() {
        return null;
    }
}
