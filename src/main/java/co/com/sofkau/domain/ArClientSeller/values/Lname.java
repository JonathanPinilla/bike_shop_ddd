package co.com.sofkau.domain.ArClientSeller.values;

import co.com.sofkau.generic.ValueObject;

public class Lname implements ValueObject<String> {
    private String lname;

    public Lname(String lname) {
        this.lname = lname;
    }

    @Override
    public String value() {
        return lname;
    }
}
