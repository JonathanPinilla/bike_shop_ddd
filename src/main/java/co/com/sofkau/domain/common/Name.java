package co.com.sofkau.domain.common;

import co.com.sofkau.generic.ValueObject;

public class Name implements ValueObject<String> {
    private String name;

    public Name(String name){
        this.name = name;
    }
    @Override
    public String value() {
        return name;
    }
}
