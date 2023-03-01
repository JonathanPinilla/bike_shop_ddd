package co.com.sofkau.domain.bikesMAR.commands;

import co.com.sofkau.generic.Command;

public class CreateBike extends Command {
    private final String brand;
    private final String type;
    private final String usage;
    private final String price;

    public CreateBike(String brand, String type, String usage, String price) {
        this.brand = brand;
        this.type = type;
        this.usage = usage;
        this.price = price;
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

    public String getPrice() {
        return price;
    }
}
