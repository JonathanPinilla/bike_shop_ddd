package co.com.sofkau.domain.ArClientSeller;

import co.com.sofkau.domain.ArClientSeller.values.*;
import co.com.sofkau.domain.common.ClientId;
import co.com.sofkau.domain.common.Name;
import co.com.sofkau.generic.Entity;

import java.util.List;

public class Client extends Entity<ClientId> {

    protected Name name;
    protected Lname lname;
    protected Address address;
    protected CreditCard creditCard;

    public Client(ClientId clientId,Name name, Lname lname, Address address, CreditCard creditCard) {
        super(clientId);
        this.name = name;
        this.lname = lname;
        this.address = address;
        this.creditCard = creditCard;
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
}
