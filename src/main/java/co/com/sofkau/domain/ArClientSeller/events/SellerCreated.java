package co.com.sofkau.domain.ArClientSeller.events;

import co.com.sofkau.generic.DomainEvent;

public class SellerCreated extends DomainEvent {

    private final String name;
    private final String lname;
    private final String charge;

    public SellerCreated(String name, String lname, String charge) {
        super("co.com.sofkau.ArClientSeller.Seller.created");
        this.name = name;
        this.lname = lname;
        this.charge = charge;
    }

    public String getName() {
        return name;
    }

    public String getLname() {
        return lname;
    }

    public String getCharge() {
        return charge;
    }
}
