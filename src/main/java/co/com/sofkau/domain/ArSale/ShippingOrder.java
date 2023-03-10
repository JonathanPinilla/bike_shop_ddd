package co.com.sofkau.domain.ArSale;

import co.com.sofkau.domain.common.Price;
import co.com.sofkau.domain.common.Date;
import co.com.sofkau.domain.ArSale.values.ShippingTime;
import co.com.sofkau.domain.ArSale.values.State;
import co.com.sofkau.domain.common.ShippingOrderId;
import co.com.sofkau.generic.Entity;

public class ShippingOrder extends Entity<ShippingOrderId> {

    protected Date date;
    protected Price price;
    protected ShippingTime shippingTime;
    protected State state;

    public ShippingOrder(ShippingOrderId shippingOrderId, Date date, Price price, ShippingTime shippingTime, State state) {
        super(shippingOrderId);
        this.date = date;
        this.price = price;
        this.shippingTime = shippingTime;
        this.state = state;
    }

    public void changeState(State state) {
        this.state = state;
    }

    public void updateShippingTime(ShippingTime shippingTime) {
        this.shippingTime = shippingTime;
    }

    public Date date() {
        return date;
    }

    public Price price() {
        return price;
    }

    public ShippingTime shippingTime() {
        return shippingTime;
    }

    public State state() {
        return state;
    }
}
