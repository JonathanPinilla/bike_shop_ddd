package co.com.sofkau.domain.ArSale.events;

import co.com.sofkau.domain.ArSale.ShippingOrder;
import co.com.sofkau.generic.DomainEvent;

public class ShippingOrderAdded extends DomainEvent {

    private final ShippingOrder shippingOrder;

    public ShippingOrderAdded(ShippingOrder shippingOrder) {
        super("co.com.sofkau.ArSale.ShippingOrder.added");
        this.shippingOrder = shippingOrder;
    }

    public ShippingOrder getShippingOrder() {
        return shippingOrder;
    }
}
