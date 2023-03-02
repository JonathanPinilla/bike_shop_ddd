package co.com.sofkau.domain.ArBikeM.events;

import co.com.sofkau.generic.DomainEvent;

public class SparePartCreated extends DomainEvent {

    private final String sparePartId;
    private final String name;
    private final String reference;
    private final String usage;
    private final Double price;

    public SparePartCreated(String sparePartId, String name, String reference, String usage, Double price) {
        super("co.com.sofkau.ArBikeM.SparePart.created");
        this.sparePartId = sparePartId;
        this.name = name;
        this.reference = reference;
        this.usage = usage;
        this.price = price;
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
}
