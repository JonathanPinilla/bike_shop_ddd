package co.com.sofkau.domain.ArSale.events;

import co.com.sofkau.generic.DomainEvent;

public class ShippingOrderStateChanged extends DomainEvent {

    private final String saleId;
    private final String shippingOrderId;
    private final String state;

    public ShippingOrderStateChanged(String saleId, String shippingOrderId, String state) {
        super("sofkau.ArSale.ShippingOrderState.changed");
        this.saleId = saleId;
        this.shippingOrderId = shippingOrderId;
        this.state = state;
    }

    public String saleId() {
        return saleId;
    }

    public String shippingOrderId() {
        return shippingOrderId;
    }

    public String state() {
        return state;
    }

}
