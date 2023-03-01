package co.com.sofkau.domain.ArBikeM.values;

import co.com.sofkau.generic.ValueObject;

public class Brand implements ValueObject<String> {
    private String brand;

    public Brand(String brand) {
        this.brand = brand;
    }

    @Override
    public String value() {
        return brand;
    }
}
