package co.com.sofkau.domain.ArBikeM.values;

import co.com.sofkau.generic.ValueObject;

public class Reference implements ValueObject<String> {
    private String reference;

    public Reference(String reference) {
        this.reference = reference;
    }

    @Override
    public String value() {
        return reference;
    }
}
