package co.com.sofkau.domain.ArBikeM.commands;

import co.com.sofkau.domain.ArBikeM.SparePart;
import co.com.sofkau.generic.Command;

public class AddSparePartToManager extends Command {

    private String bikeManagerId;
    private String sparePartId;
    private String name;
    private String reference;
    private String usage;
    private Double price;

    public AddSparePartToManager(String bikeManagerId, String sparePartId, String name, String reference, String usage, Double price) {
        this.bikeManagerId = bikeManagerId;
        this.sparePartId = sparePartId;
        this.name = name;
        this.reference = reference;
        this.usage = usage;
        this.price = price;
    }

    public String getBikeManagerId() {
        return bikeManagerId;
    }

    public String getSparePartId() {
        return sparePartId;
    }

    public String getName() {
        return name;
    }

    public String getReference() {
        return reference;
    }

    public String getUsage() {
        return usage;
    }

    public Double getPrice() {
        return price;
    }

    public void setBikeManagerId(String bikeManagerId) {
        this.bikeManagerId = bikeManagerId;
    }

    public void setSparePartId(String sparePartId) {
        this.sparePartId = sparePartId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public void setUsage(String usage) {
        this.usage = usage;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
