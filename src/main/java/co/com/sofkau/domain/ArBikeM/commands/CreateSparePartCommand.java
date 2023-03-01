package co.com.sofkau.domain.ArBikeM.commands;

import co.com.sofkau.domain.ArBikeM.values.Reference;
import co.com.sofkau.domain.ArBikeM.values.Usage;
import co.com.sofkau.domain.common.Id;
import co.com.sofkau.domain.common.Name;
import co.com.sofkau.domain.common.Price;
import co.com.sofkau.generic.Command;

public class CreateSparePartCommand extends Command {

    private Id id;
    private Name name;
    private Reference reference;
    private Usage usage;
    private Price price;

    public CreateSparePartCommand(Id id, Name name, Reference reference, Usage usage, Price price) {
        this.id = id;
        this.name = name;
        this.reference = reference;
        this.usage = usage;
        this.price = price;
    }

    public Id getId() {
        return id;
    }

    public void setId(Id id) {
        this.id = id;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public Reference getReference() {
        return reference;
    }

    public void setReference(Reference reference) {
        this.reference = reference;
    }

    public Usage getUsage() {
        return usage;
    }

    public void setUsage(Usage usage) {
        this.usage = usage;
    }

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }
}
