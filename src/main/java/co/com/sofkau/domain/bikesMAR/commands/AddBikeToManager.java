package co.com.sofkau.domain.bikesMAR.commands;

import co.com.sofkau.generic.Command;

public class AddBikeToManager extends Command {

    private final String bikeManagerId;
    private final String bikeId;

    public AddBikeToManager(String bikeManagerId, String bikeId) {
        this.bikeManagerId = bikeManagerId;
        this.bikeId = bikeId;
    }

    public String getBikeManagerId() {
        return bikeManagerId;
    }

    public String getBikeId() {
        return bikeId;
    }
}
