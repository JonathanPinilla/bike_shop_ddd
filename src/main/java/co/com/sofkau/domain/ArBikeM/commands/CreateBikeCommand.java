package co.com.sofkau.domain.ArBikeM.commands;

import co.com.sofkau.domain.ArBikeM.values.Brand;
import co.com.sofkau.domain.ArBikeM.values.Usage;
import co.com.sofkau.domain.common.Price;
import co.com.sofkau.domain.common.Type;
import co.com.sofkau.generic.Command;

public class CreateBikeCommand extends Command {
    private Brand brand;
    private Type type;
    private Usage usage;
    private Price price;

    public CreateBikeCommand(Brand brand, Type type, Usage usage, Price price) {
        this.brand = brand;
        this.type = type;
        this.usage = usage;
        this.price = price;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
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
