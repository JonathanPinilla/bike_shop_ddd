package co.com.sofkau.domain.ArBikeM.events;

import co.com.sofkau.domain.common.Price;
import co.com.sofkau.generic.DomainEvent;

public class BikePriceChanged extends DomainEvent {

    Double price;
    String bikeId;

    public BikePriceChanged(String bikeId, Double price) {
        super("sofkau.ArBikeM.BikePrice.changed");
        this.price = price;
        this.bikeId = bikeId;
    }

    public Double price() {
        return price;
    }

    public String bikeId() {
        return bikeId;
    }
}
