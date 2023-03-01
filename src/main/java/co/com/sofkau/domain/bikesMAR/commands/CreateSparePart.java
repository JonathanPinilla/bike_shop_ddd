package co.com.sofkau.domain.bikesMAR.commands;

import co.com.sofkau.generic.Command;

public class CreateSparePart extends Command {

    private final String id;
    private final String name;
    private final String reference;
    private final String usage;
    private final String price;

    public CreateSparePart(String id, String name, String reference, String usage, String price) {
        this.id = id;
        this.name = name;
        this.reference = reference;
        this.usage = usage;
        this.price = price;
    }

    public String getId() {
        return id;
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

    public String getPrice() {
        return price;
    }
}
