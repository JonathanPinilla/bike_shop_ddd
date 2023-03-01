package co.com.sofkau.domain.ArClientSeller.events;

import co.com.sofkau.domain.ArClientSeller.Client;
import co.com.sofkau.generic.DomainEvent;

public class ClientAdded extends DomainEvent{

    private final Client client;

    public ClientAdded(Client client) {
        super("co.com.sofkau.ArClientSeller.Client.added");
        this.client = client;
    }

    public Client getClient() {
        return client;
    }
}
