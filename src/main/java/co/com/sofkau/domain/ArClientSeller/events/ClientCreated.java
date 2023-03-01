package co.com.sofkau.domain.ArClientSeller.events;

import co.com.sofkau.domain.ArClientSeller.values.Address;
import co.com.sofkau.domain.ArClientSeller.values.Lname;
import co.com.sofkau.domain.common.Name;
import co.com.sofkau.generic.DomainEvent;

public class ClientCreated extends DomainEvent {

    //Event of client created

    private final Name name;
    private final Lname lname;
    private final Address address;

    public ClientCreated(Name name, Lname lname, Address address) {
        super("co.com.sofkau.ArClientSeller.Client.created");
        this.name = name;
        this.lname = lname;
        this.address = address;
    }

    public Name getName() {
        return name;
    }

    public Lname getLname() {
        return lname;
    }

    public Address getAddress() {
        return address;
    }
}
