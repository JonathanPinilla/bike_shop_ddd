package co.com.sofkau.domain.bikesMAR.values;

import co.com.sofkau.generic.ValueObject;

public class Usage implements ValueObject<String> {
    private String usage;

    public Usage(String usage) {
        this.usage = usage;
    }

    @Override
    public String value() {
        return usage;
    }
}
