package co.com.sofkau.domain.client_sellerAR;

import co.com.sofkau.domain.client_sellerAR.values.*;
import co.com.sofkau.domain.common.Name;

import java.util.List;

public class Client {

    protected Name name;
    protected Lname lname;
    protected Address address;
    protected CreditCard creditCard;
    protected List<Sale> saleList;

    public Client(Name name, Lname lname, Address address, CreditCard creditCard, List<Sale> saleList) {
        this.name = name;
        this.lname = lname;
        this.address = address;
        this.creditCard = creditCard;
        this.saleList = saleList;
    }

    public void updateClientName(String reason, Name name) {

        if (!reason.equals("")) {
            throw new IllegalArgumentException("Reason should be added to change the name of a Client");
        }
        this.name = name;

    }

    public void updateClientLname(String reason, Lname lname) {

        if (!reason.equals("")) {
            throw new IllegalArgumentException("Reason should be added to change the lname of a Client");
        }
        this.lname = lname;

    }

    public void updateClientAddress(String reason, Address address) {

        if (!reason.equals("")) {
            throw new IllegalArgumentException("Reason should be added to change the address of a Client");
        }
        this.address = address;

    }

    public void changeCreditCard(CreditCard creditCard) {
        this.creditCard = creditCard;
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

    public Address address() {
        return address;
    }

    public CreditCard creditCard() {//Check security actions in this case
        return creditCard;
    }

    public List<Sale> saleList() {
        return saleList;
    }
}
