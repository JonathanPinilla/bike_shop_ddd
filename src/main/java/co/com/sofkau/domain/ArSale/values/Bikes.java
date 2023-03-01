package co.com.sofkau.domain.ArSale.values;

import co.com.sofkau.domain.common.BikeId;
import co.com.sofkau.domain.common.Id;
import co.com.sofkau.generic.ValueObject;

import java.util.List;

public class Bikes implements ValueObject<Bikes.Props> {
    List<BikeId> bikes;

    public Bikes(List<BikeId> bikes) {
        this.bikes = bikes;
    }

    @Override
    public Props value() {
        return new Props() {
            @Override
            public List<BikeId> bikes() {
                return bikes;
            }
        };
    }

    public void add(BikeId bikeId) {
        this.bikes.add(bikeId);
    }

    interface Props {
        List<BikeId> bikes();
    }

}
