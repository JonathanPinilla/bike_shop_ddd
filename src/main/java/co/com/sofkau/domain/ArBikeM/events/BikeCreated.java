package co.com.sofkau.domain.ArBikeM.events;

import co.com.sofkau.generic.DomainEvent;

public class BikeCreated extends DomainEvent {

    private final String bikeId;
    private final String brand;
    private final String type;
    private final String usage;
    private final Double price;
    private final Boolean sold;

    public BikeCreated(String bikeId, String brand, String type1, String usage, Double price, Boolean sold) {
        super("co.com.sofkau.ArBikeM.Bike.created");
        this.bikeId = bikeId;
        this.brand = brand;
        this.type = type1;
        this.usage = usage;
        this.price = price;
        this.sold = sold;
    }

    public String getBikeId(){
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
}
