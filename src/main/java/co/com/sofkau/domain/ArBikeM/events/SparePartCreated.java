package co.com.sofkau.domain.ArBikeM.events;

import co.com.sofkau.domain.ArBikeM.values.Reference;
import co.com.sofkau.domain.ArBikeM.values.Usage;
import co.com.sofkau.domain.common.Id;
import co.com.sofkau.domain.common.Name;
import co.com.sofkau.domain.common.Price;
import co.com.sofkau.generic.DomainEvent;

public class SparePartCreated extends DomainEvent {

    private final Id id;
    private final Name name;
    private final Reference reference;
    private final Usage usage;
    private final Price price;

    public SparePartCreated(Id id, Name name, Reference reference, Usage usage, Price price) {
        super("co.com.sofkau.ArBikeM.SparePart.created");
        this.id = id;
        this.name = name;
        this.reference = reference;
        this.usage = usage;
        this.price = price;
    }

    public Id getId() {
        return id;
    }

    public Name getName() {
        return name;
    }

    public Reference getReference() {
        return reference;
    }

    public Usage getUsage() {
        return usage;
    }

    public Price getPrice() {
        return price;
    }
}
