package co.com.sofkau.domain.ArSale.values;

import co.com.sofkau.domain.common.Id;
import co.com.sofkau.generic.ValueObject;

import java.util.List;

public class Bikes implements ValueObject<Bikes.Props> {
    List<Id> bikes;

    public Bikes(List<Id> bikes) {
        this.bikes = bikes;
    }

    @Override
    public Props value() {
        return new Props() {
            @Override
            public List<Id> bikes() {
                return bikes;
            }
        };
    }

    public void add(Id bikeId) {
        this.bikes.add(bikeId);
    }

    interface Props {
        List<Id> bikes();
    }

}
