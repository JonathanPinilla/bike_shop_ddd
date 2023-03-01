package co.com.sofkau.domain.ArSale.events;
import co.com.sofkau.generic.DomainEvent;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ShippingOrderAdded extends DomainEvent {
    private final String shippingOrderId;
    private final LocalDate date;
    private final Double price;
    private final LocalDateTime shippingTime;
    private final String state;

    public ShippingOrderAdded(String shippingOrderId, LocalDate date, Double price, LocalDateTime shippingTime, String state) {
        super("co.com.sofkau.ArSale.ShippingOrder.added");
        this.shippingOrderId = shippingOrderId;
        this.date = date;
        this.price = price;
        this.shippingTime = shippingTime;
        this.state = state;
    }

    public String getShippingOrderId() {
        return shippingOrderId;
    }
    public LocalDate getDate() {
        return date;
    }

    public Double getPrice() {
        return price;
    }

    public LocalDateTime getShippingTime() {
        return shippingTime;
    }

    public String getState() {
        return state;
    }
}
