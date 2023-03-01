package co.com.sofkau.domain.ArClientSeller;

import co.com.sofkau.domain.ArClientSeller.values.Charge;
import co.com.sofkau.domain.ArClientSeller.values.Lname;
import co.com.sofkau.domain.ArClientSeller.values.Sale;
import co.com.sofkau.domain.common.Id;
import co.com.sofkau.domain.common.Name;
import co.com.sofkau.generic.Entity;

import java.util.List;

public class Seller extends Entity<Id> {

    private Name name;
    private Lname lname;
    private Charge charge;
    private List<Sale> saleList;

    public Seller(Id id, Name name, Lname lname, Charge charge, List<Sale> saleList) {
        super(id);
        this.name = name;
        this.lname = lname;
        this.charge = charge;
        this.saleList = saleList;
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

    public void updateSalesList(Sale sale) {
        this.saleList.add(sale);
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

    public List<Sale> saleList() {
        return saleList;
    }
}
