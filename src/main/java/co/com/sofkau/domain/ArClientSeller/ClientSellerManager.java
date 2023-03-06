package co.com.sofkau.domain.ArClientSeller;

import co.com.sofkau.domain.ArClientSeller.events.*;
import co.com.sofkau.domain.ArClientSeller.values.Address;
import co.com.sofkau.domain.ArClientSeller.values.Charge;
import co.com.sofkau.domain.ArClientSeller.values.Lname;
import co.com.sofkau.domain.common.*;
import co.com.sofkau.generic.AggregateRoot;
import co.com.sofkau.generic.DomainEvent;

import java.time.LocalDate;
import java.util.List;

public class ClientSellerManager extends AggregateRoot<ClientSellerManagerId> {

    protected ClientSellerManagerId clientSellerId;
    protected List<Client> clientList;
    protected List<Seller> sellerList;
    protected Date creationDate;


    public ClientSellerManager(ClientSellerManagerId clientSellerId, LocalDate creationDate) {
        super(clientSellerId);
        subscribe(new ClientSellerManagerEventChange(this));
        appendChange(new ClientSellerCreated(creationDate)).apply();
    }

    private ClientSellerManager(ClientSellerManagerId clientSellerId) {
        super(clientSellerId);
        subscribe(new ClientSellerManagerEventChange(this));
    }

    public static ClientSellerManager from(ClientSellerManagerId clientSellerId, List<DomainEvent> events) {
        var clientSellerManager = new ClientSellerManager(clientSellerId);
        events.forEach(clientSellerManager::applyEvent);
        return clientSellerManager;
    }

    public void createClient(ClientId clientId, Name name, Lname lname, Address address) {
        appendChange(new ClientCreated(clientId.value(), name.value(), lname.value(), address.value())).apply();
    }

    public void createSeller(Name name, Lname lname, Charge charge) {
        appendChange(new SellerCreated(name.value(), lname.value(), charge.value())).apply();
    }

    public void addClient(ClientId clientId, Name name, Lname lname, Address address) {
        appendChange(new ClientAdded(clientId.value(), name.value(), lname.value(), address.value())).apply();
    }

    public void changeClientAddress(ClientId clientId, Address address) {
        appendChange(new ClientAddressChanged(clientId.value(), address.value())).apply();
    }

    public void addSeller(SellerId sellerId, Name name, Lname lname, Charge charge) {
        appendChange(new SellerAdded(sellerId.value(), name.value(), lname.value(), charge.value())).apply();
    }

    public List<Client> getClientList() {
        return clientList;
    }

    public List<Seller> getSellerList() {
        return sellerList;
    }
}
