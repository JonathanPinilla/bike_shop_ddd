package co.com.sofkau.domain.ArBikeM.commands;

import co.com.sofkau.generic.Command;

public class CreateBikeManager extends Command {

    private final String bikeManagerId;

    public CreateBikeManager(String bikeManagerId) {
        this.bikeManagerId = bikeManagerId;
    }

    public String getBikeManagerId() {
        return bikeManagerId;
    }
}
