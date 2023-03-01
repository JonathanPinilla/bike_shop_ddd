package co.com.sofkau.domain.ArSale.values;

import co.com.sofkau.generic.ValueObject;

public class State implements ValueObject<String> {

    private String state;

    public State(String state) {
        this.state = state;
    }

    @Override
    public String value() {
        return state;
    }
}
