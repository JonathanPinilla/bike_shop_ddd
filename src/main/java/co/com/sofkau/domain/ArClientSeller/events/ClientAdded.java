package co.com.sofkau.domain.ArClientSeller.events;

import co.com.sofkau.generic.DomainEvent;

public class ClientAdded extends DomainEvent{

    private final String clientId;
    private final String name;
    private final String lname;
    private final String address;

    public ClientAdded(String clientId, String name, String lname, String address) {
        super("co.com.sofkau.ArClientSeller.Client.added");
        this.clientId = clientId;
        this.name = name;
        this.lname = lname;
        this.address = address;
    }

    public String getClientId() {
        return clientId;
    }

    public String getName() {
        return name;
    }

    public String getLname() {
        return lname;
    }

    public String getAddress() {
        return address;
    }
}
