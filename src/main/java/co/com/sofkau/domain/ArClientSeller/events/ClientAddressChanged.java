package co.com.sofkau.domain.ArClientSeller.events;

import co.com.sofkau.generic.DomainEvent;

public class ClientAddressChanged extends DomainEvent {

    private final String clientId;
    private final String address;

    public ClientAddressChanged(String clientId, String address) {
        super("sofkau.domain.clientAddress.changed");
        this.clientId = clientId;
        this.address = address;
    }

    public String getClientId() {
        return clientId;
    }

    public String getAddress() {
        return address;
    }
}
