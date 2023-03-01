package co.com.sofkau.domain.ArSale.events;

import co.com.sofkau.domain.ArSale.values.Client;
import co.com.sofkau.domain.ArSale.values.Seller;
import co.com.sofkau.generic.DomainEvent;

public class SaleCreated extends DomainEvent {

    private final Client client;
    private final Seller seller;

    public SaleCreated(Client client, Seller seller) {
        super("co.com.sofkau.ArSale.Sale.created");
        this.client = client;
        this.seller = seller;
    }

    public Client getClient() {
        return client;
    }

    public Seller getSeller() {
        return seller;
    }
}
