package co.com.sofkau.domain.ArBikeM.commands;

import co.com.sofkau.domain.ArBikeM.Bike;
import co.com.sofkau.generic.Command;

public class AddBikeToManager extends Command {

    private final String bikeManagerId;
    private final String bikeId;
    private final String brand;
    private final String type;
    private final String usage;
    private final Double price;
    private final Boolean sold;

    public AddBikeToManager(String bikeManagerId, String bikeId, String brand, String type, String usage, Double price, Boolean sold) {
        this.bikeManagerId = bikeManagerId;
        this.bikeId = bikeId;
        this.brand = brand;
        this.type = type;
        this.usage = usage;
        this.price = price;
        this.sold = sold;
    }

    public String getBikeId() {
        return bikeId;
    }

    public String getBrand() {
        return brand;
    }

    public String getType() {
        return type;
    }

    public String getUsage() {
        return usage;
    }

    public Double getPrice() {
        return price;
    }

    public Boolean getSold() {
        return sold;
    }

    public String getBikeManagerId() {
        return bikeManagerId;
    }

}
