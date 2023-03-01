package co.com.sofkau.domain.ArSale.events;

import co.com.sofkau.generic.DomainEvent;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ShippingOrderCreated extends DomainEvent {

    private final String price;
    private final LocalDate localDate;
    private final String shippingTime;
    private final LocalDateTime state;

    public ShippingOrderCreated(String price, LocalDate localDate, String shippingTime, LocalDateTime state) {
        super("co.com.sofkau.ArSale.ShippingOrder.created");
        this.price = price;
        this.localDate = localDate;
        this.shippingTime = shippingTime;
        this.state = state;
    }

    public String getPrice() {
        return price;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public String getShippingTime() {
        return shippingTime;
    }

    public LocalDateTime getState() {
        return state;
    }
}
