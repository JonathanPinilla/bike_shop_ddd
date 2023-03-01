package co.com.sofkau.domain.ArBikeM;

import co.com.sofkau.domain.ArBikeM.values.*;
import co.com.sofkau.domain.common.Id;
import co.com.sofkau.domain.common.Price;
import co.com.sofkau.domain.common.Type;
import co.com.sofkau.generic.Entity;

import java.util.List;

public class Bike extends Entity<Id> {
    protected Brand brand;
    protected Type type;
    protected Usage usage;
    protected List<Maintenance> maintenances;
    protected Price price;
    protected Sold sold;

    public Bike(Id id, Brand brand, Type type, Usage usage, List<Maintenance> maintenances, Price price, Sold sold) {
        super(id);
        this.brand = brand;
        this.type = type;
        this.usage = usage;
        this.maintenances = maintenances;
        this.price = price;
        this.sold = sold;
    }

    public void updateMaintenance(Maintenance maintenance) {
        this.maintenances.add(maintenance);
    }

    public void updateSold(Sold sold) {
        this.sold = sold;
    }

    public void changePrice(String reason, Price price) {
        if (!reason.equals("IPC")) {
            throw new IllegalArgumentException("The reason should be IPC or else you can't change the price");
        }
        this.price = price;
    }

    public Brand brand(){
        return brand;
    }

    public Type type(){
        return type;
    }

    public Usage usage(){
        return usage;
    }

    public List<Maintenance> maintenances(){
        return maintenances;
    }

    public Price price(){
        return price;
    }

    public Sold sold(){
        return sold;
    }

}
