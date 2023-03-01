package co.com.sofkau.domain.ArClientSeller.events;

import co.com.sofkau.domain.ArClientSeller.values.Charge;
import co.com.sofkau.domain.ArClientSeller.values.Lname;
import co.com.sofkau.domain.common.Name;
import co.com.sofkau.generic.DomainEvent;

public class SellerCreated extends DomainEvent {

    private final Name name;
    private final Lname lname;
    private final Charge charge;

    public SellerCreated(Name name, Lname lname, Charge charge) {
        super("co.com.sofkau.ArClientSeller.Seller.created");
        this.name = name;
        this.lname = lname;
        this.charge = charge;
    }

    public Name getName() {
        return name;
    }

    public Lname getLname() {
        return lname;
    }

    public Charge getCharge() {
        return charge;
    }
}
