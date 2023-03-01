package co.com.sofkau.domain.ArBikeM.commands;

import co.com.sofkau.domain.ArBikeM.Bike;
import co.com.sofkau.domain.common.Id;
import co.com.sofkau.generic.Command;

public class AddBikeToManager extends Command {

    private final Id bikeManagerId;
    private final Bike bike;

    public AddBikeToManager(Id bikeManagerId, Bike bike) {
        this.bikeManagerId = bikeManagerId;
        this.bike = bike;
    }

    public Id getBikeManagerId() {
        return bikeManagerId;
    }

    public Bike getBike() {
        return bike;
    }
}
