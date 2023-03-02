package co.com.sofkau.domain.ArClientSeller;

import co.com.sofkau.domain.ArClientSeller.values.Charge;
import co.com.sofkau.domain.ArClientSeller.values.Lname;
import co.com.sofkau.domain.common.Name;
import co.com.sofkau.domain.common.SellerId;
import co.com.sofkau.generic.Entity;

public class Seller extends Entity<SellerId> {

    private Name name;
    private Lname lname;
    private Charge charge;

    public Seller(SellerId sellerId, Name name, Lname lname, Charge charge) {
        super(sellerId);
        this.name = name;
        this.lname = lname;
        this.charge = charge;
    }

    public void updateSellerName(String reason, Name name) {

        if (!reason.equals("")) {
            throw new IllegalArgumentException("Reason should be added to change the name of a Seller");
        }
        this.name = name;

    }

    public void updateSellerLname(String reason, Lname lname) {

        if (!reason.equals("")) {
            throw new IllegalArgumentException("Reason should be added to change the lname of a Seller");
        }
        this.lname = lname;

    }

    public void updateSellerCharge(String reason, Charge charge) {

        if (!reason.equals("")) {
            throw new IllegalArgumentException("Reason should be added to change the charge of a Seller");
        }
        this.charge = charge;

    }

    public Name name() {
        return name;
    }

    public Lname lname() {
        return lname;
    }

    public Charge charge() {
        return charge;
    }
}
