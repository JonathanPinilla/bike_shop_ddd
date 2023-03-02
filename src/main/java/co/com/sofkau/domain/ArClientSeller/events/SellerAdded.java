package co.com.sofkau.domain.ArClientSeller.events;

import co.com.sofkau.generic.DomainEvent;

public class SellerAdded extends DomainEvent {

    private final String sellerId;
    private final String name;
    private final String lname;
    private final String charge;

    public SellerAdded(String sellerId, String name, String lname, String charge) {
        super("co.com.sofkau.ArClientSeller.Seller.added");
        this.sellerId = sellerId;
        this.name = name;
        this.lname = lname;
        this.charge = charge;
    }

    public String getSellerId() {
        return sellerId;
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
