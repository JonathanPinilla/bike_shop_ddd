package co.com.sofkau.domain.ArClientSeller;

import co.com.sofkau.domain.ArClientSeller.values.*;
import co.com.sofkau.domain.common.ClientId;
import co.com.sofkau.domain.common.Name;
import co.com.sofkau.generic.Entity;

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

    public void changeAddress(Address address) {
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
