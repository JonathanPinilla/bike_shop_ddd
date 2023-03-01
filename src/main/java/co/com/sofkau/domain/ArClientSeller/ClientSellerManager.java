package co.com.sofkau.domain.ArClientSeller;

import co.com.sofkau.domain.ArClientSeller.events.*;
import co.com.sofkau.domain.ArClientSeller.values.Address;
import co.com.sofkau.domain.ArClientSeller.values.Charge;
import co.com.sofkau.domain.ArClientSeller.values.Lname;
import co.com.sofkau.domain.common.Date;
import co.com.sofkau.domain.common.Id;
import co.com.sofkau.domain.common.Name;
import co.com.sofkau.generic.AggregateRoot;
import co.com.sofkau.generic.DomainEvent;

import java.util.List;

public class ClientSellerManager extends AggregateRoot<Id> {

    protected Id clientSellerId;
    protected Client client;
    protected Seller seller;
    protected Date creationDate;

    public ClientSellerManager(Id entityId, Date creationDate) {
        super(entityId);
        subscribe(new ClientSellerManagerEventChange(this));
        appendChange(new ClientSellerCreated(creationDate)).apply();
    }

    private ClientSellerManager(Id clientSellerId) {
        super(clientSellerId);
        subscribe(new ClientSellerManagerEventChange(this));
    }

    public static ClientSellerManager from(Id clientSellerId, List<DomainEvent> events) {
        var clientSellerManager = new ClientSellerManager(clientSellerId);
        events.forEach(clientSellerManager::applyEvent);
        return clientSellerManager;
    }

    public void createClient(Name name, Lname lname, Address address) {
        appendChange(new ClientCreated(name, lname, address)).apply();
    }

    public void createSeller(Name name, Lname lname, Charge charge) {
        appendChange(new SellerCreated(name, lname, charge)).apply();
    }

    public void addClient(Client client) {
        appendChange(new ClientAdded(client)).apply();
    }

    public void addSeller(Seller seller) {
        appendChange(new SellerAdded(seller)).apply();
    }

    public Client getClient() {
        return client;
    }

    public Seller getSeller() {
        return seller;
    }
}
