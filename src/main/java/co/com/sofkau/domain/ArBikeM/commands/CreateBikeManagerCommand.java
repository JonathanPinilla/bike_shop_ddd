package co.com.sofkau.domain.ArBikeM.commands;

import co.com.sofkau.generic.Command;

public class CreateBikeManagerCommand extends Command {

    private String bikeManagerId;

    public String getBikeManagerId() {
        return bikeManagerId;
    }

    public void setBikeManagerId(String bikeManagerId) {
        this.bikeManagerId = bikeManagerId;
    }
}
