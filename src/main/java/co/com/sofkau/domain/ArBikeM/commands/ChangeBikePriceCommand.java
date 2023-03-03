package co.com.sofkau.domain.ArBikeM.commands;

import co.com.sofkau.generic.Command;

public class ChangeBikePriceCommand extends Command {
    private final String bikeManagerId;
    private final String bikeId;
    private final Double price;

    public ChangeBikePriceCommand(String bikeManagerId, String bikeId, Double price) {
        this.bikeManagerId = bikeManagerId;
        this.bikeId = bikeId;
        this.price = price;
    }

    public String getBikeId() {
        return bikeId;
    }

    public Double getPrice() {
        return price;
    }

    public String getBikeManagerId() {
        return bikeManagerId;
    }

}
