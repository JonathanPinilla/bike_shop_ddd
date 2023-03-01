package co.com.sofkau.domain.saleAR;

import co.com.sofkau.domain.common.Id;
import co.com.sofkau.domain.common.Price;
import co.com.sofkau.domain.saleAR.values.Date;
import co.com.sofkau.domain.saleAR.values.ShippingTime;
import co.com.sofkau.domain.saleAR.values.State;
import co.com.sofkau.generic.Entity;

public class ShippingOrder extends Entity<Id> {

    protected Date date;
    protected Price price;
    protected ShippingTime shippingTime;
    protected State state;

    public ShippingOrder(Id id, Date date, Price price, ShippingTime shippingTime, State state) {
        super(id);
        this.date = date;
        this.price = price;
        this.shippingTime = shippingTime;
        this.state = state;
    }

    public void updateState(State state) {
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
