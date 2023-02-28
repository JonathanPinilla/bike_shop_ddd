package co.com.sofkau.domain.common;

import co.com.sofkau.generic.ValueObject;

public class Type implements ValueObject<String> {
    private String type;

    public Type(String type) {
        this.type = type;
    }

    @Override
    public String value() {
        return type;
    }
}
