package co.com.sofkau.domain.bikesMAR.values;

import co.com.sofkau.generic.ValueObject;

public class Sold implements ValueObject<Boolean> {
    private Boolean sold;

    public Sold(Boolean sold){
        this.sold = sold;
    }
    @Override
    public Boolean value() {
        return sold;
    }
}
