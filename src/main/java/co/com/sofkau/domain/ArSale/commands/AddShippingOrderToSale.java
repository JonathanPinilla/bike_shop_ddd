package co.com.sofkau.domain.ArSale.commands;

import co.com.sofkau.domain.ArSale.ShippingOrder;
import co.com.sofkau.generic.Command;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class AddShippingOrderToSale extends Command {

    private final String saleId;
    private final String shippingOrderId;
    private final LocalDate date;
    private final double price;
    private final LocalDateTime shippingTime;
    private final String state;

    public AddShippingOrderToSale(String saleId, String shippingOrderId, LocalDate date, double price, LocalDateTime shippingTime, String state) {
        this.saleId = saleId;
        this.shippingOrderId = shippingOrderId;
        this.date = date;
        this.price = price;
        this.shippingTime = shippingTime;
        this.state = state;
    }

    public String getSaleId() {
        return saleId;
    }

    public String getShippingOrderId() {
        return shippingOrderId;
    }

    public LocalDate getDate() {
        return date;
    }

    public double getPrice() {
        return price;
    }

    public LocalDateTime getShippingTime() {
        return shippingTime;
    }

    public String getState() {
        return state;
    }
}
