package co.com.sofkau.domain.ArSale.events;

import co.com.sofkau.generic.DomainEvent;

public class SaleCreated extends DomainEvent {

    private final String client;
    private final String seller;

    public SaleCreated(String client, String seller) {
        super("co.com.sofkau.ArSale.Sale.created");
        this.client = client;
        this.seller = seller;
    }

    public String getClient() {
        return client;
    }

    public String getSeller() {
        return seller;
    }
}
