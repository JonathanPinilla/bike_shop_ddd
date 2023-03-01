package co.com.sofkau.domain.ArBikeM.events;

import co.com.sofkau.domain.ArBikeM.Bike;
import co.com.sofkau.generic.DomainEvent;

public class BikeAdded extends DomainEvent {

    private final Bike bike;

    public BikeAdded(Bike bike) {
        super("co.com.sofkau.ArBikeM.Bike.added");
        this.bike = bike;
    }

    public Bike getBike() {
        return bike;
    }
}
