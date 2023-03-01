package co.com.sofkau.domain.ArBikeM.commands;

import co.com.sofkau.generic.Command;

public class CreateBikeManager extends Command {

    private String bikeManagerId;

    public CreateBikeManager(String bikeManagerId) {
        this.bikeManagerId = bikeManagerId;
    }

    public String getBikeManagerId() {
        return bikeManagerId;
    }

    public void setBikeManagerId(String bikeManagerId) {
        this.bikeManagerId = bikeManagerId;
    }
}
