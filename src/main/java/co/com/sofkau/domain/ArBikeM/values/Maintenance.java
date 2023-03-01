package co.com.sofkau.domain.ArBikeM.values;

import co.com.sofkau.generic.ValueObject;

public class Maintenance implements ValueObject<String> {
    private String maintenance;

    public Maintenance(String maintenance) {
        this.maintenance = maintenance;
    }

    @Override
    public String value() {
        return maintenance;
    }
}
