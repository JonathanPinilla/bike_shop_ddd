package co.com.sofkau.domain.ArBikeM.commands;

import co.com.sofkau.generic.Command;

public class CreateBike extends Command {
    private String brand;
    private String type;
    private String usage;
    private String price;

    public CreateBike(String brand, String type, String usage, String price) {
        this.brand = brand;
        this.type = type;
        this.usage = usage;
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUsage() {
        return usage;
    }

    public void setUsage(String usage) {
        this.usage = usage;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
