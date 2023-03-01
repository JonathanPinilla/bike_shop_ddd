package co.com.sofkau.domain.ArClientSeller.events;

import co.com.sofkau.domain.ArClientSeller.Seller;
import co.com.sofkau.generic.DomainEvent;

public class SellerAdded extends DomainEvent {

    private final Seller seller;

    public SellerAdded(Seller seller) {
        super("co.com.sofkau.ArClientSeller.Seller.added");
        this.seller = seller;
    }

    public Seller getSeller() {
        return seller;
    }
}
