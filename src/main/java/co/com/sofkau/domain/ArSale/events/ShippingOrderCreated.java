package co.com.sofkau.domain.ArSale.events;

import co.com.sofkau.domain.common.Date;
import co.com.sofkau.domain.ArSale.values.ShippingTime;
import co.com.sofkau.domain.common.Price;
import co.com.sofkau.domain.common.ShippingOrderId;
import co.com.sofkau.generic.DomainEvent;

public class ShippingOrderCreated extends DomainEvent {

    private final ShippingOrderId price;
    private final Date localDate;
    private final Price shippingTime;
    private final ShippingTime state;

    public ShippingOrderCreated(ShippingOrderId price, Date localDate, Price shippingTime, ShippingTime state) {
        super("co.com.sofkau.ArSale.ShippingOrder.created");
        this.price = price;
        this.localDate = localDate;
        this.shippingTime = shippingTime;
        this.state = state;
    }

    public ShippingOrderId getPrice() {
        return price;
    }

    public Date getLocalDate() {
        return localDate;
    }

    public Price getShippingTime() {
        return shippingTime;
    }

    public ShippingTime getState() {
        return state;
    }
}
