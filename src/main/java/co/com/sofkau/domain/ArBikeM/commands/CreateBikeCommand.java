package co.com.sofkau.domain.ArBikeM.commands;

import co.com.sofkau.generic.Command;

public class CreateBikeCommand extends Command {
    private String id;
    private String brand;
    private String type;
    private String usage;
    private Double price;

    public CreateBikeCommand(String id, String brand, String type, String usage, Double price) {
        this.id = id;
        this.brand = brand;
        this.type = type;
        this.usage = usage;
        this.price = price;
    }

    public String getId(){return id;}

    public void setId(String id) {
        this.id = id;
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
