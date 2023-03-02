package co.com.sofkau.domain.ArBikeM.commands;

import co.com.sofkau.generic.Command;

public class CreateSparePartCommand extends Command {

    private String sparePartId;
    private String name;
    private String reference;
    private String usage;
    private Double price;

    public CreateSparePartCommand(String sparePartId, String name, String reference, String usage, Double price) {
        this.sparePartId = sparePartId;
        this.name = name;
        this.reference = reference;
        this.usage = usage;
        this.price = price;
    }

    public String getSparePartId() {
        return sparePartId;
    }

    public void setSparePartId(String sparePartId) {
        this.sparePartId = sparePartId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
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
