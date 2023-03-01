package co.com.sofkau.domain.ArBikeM.events;

import co.com.sofkau.domain.ArBikeM.values.Brand;
import co.com.sofkau.domain.ArBikeM.values.Usage;
import co.com.sofkau.domain.common.Id;
import co.com.sofkau.domain.common.Price;
import co.com.sofkau.generic.DomainEvent;

public class BikeCreated extends DomainEvent {

    private final Id id;
    private final Brand brand;
    private final String type;
    private final Usage usage;
    private final Price price;

    public BikeCreated(Id id, Brand brand, String type1, Usage usage, Price price) {
        super("co.com.sofkau.ArBikeM.Bike.created");
        this.id = id;
        this.brand = brand;
        this.type = type1;
        this.usage = usage;
        this.price = price;
    }

    public Id getId(){
        return id;
    }

    public Brand getBrand() {
        return brand;
    }

    public String getType() {
        return type;
    }

    public Usage getUsage() {
        return usage;
    }

    public Price getPrice() {
        return price;
    }
}
