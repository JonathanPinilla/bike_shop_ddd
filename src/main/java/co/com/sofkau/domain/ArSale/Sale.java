package co.com.sofkau.domain.ArSale;

import co.com.sofkau.domain.ArSale.events.*;
import co.com.sofkau.domain.ArSale.values.*;
import co.com.sofkau.domain.common.*;
import co.com.sofkau.generic.AggregateRoot;
import co.com.sofkau.generic.DomainEvent;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class Sale extends AggregateRoot<SaleId> {


    protected ClientId client;
    protected SellerId seller;
    protected Payment payment;
    protected ShippingOrder shippingOrder;

    public Sale(SaleId saleId, ClientId clientId, SellerId sellerId, Payment payment, ShippingOrder shippingOrder) {
        super(saleId);
        subscribe(new SaleEventChange(this));
        appendChange(new SaleCreated(clientId.value(), sellerId.value()));
    }

    public Sale(SaleId saleId) {
        super(saleId);
        subscribe(new SaleEventChange(this));
    }

    public Sale(SaleId saleId, ClientId clientId, SellerId sellerId) {
        super(saleId);
        subscribe(new SaleEventChange(this));
        appendChange(new SaleCreated(clientId.value(), sellerId.value()));
    }

    public static Sale from(SaleId saleId, List<DomainEvent> events) {
        var sale = new Sale(saleId);
        events.forEach(sale::applyEvent);
        return sale;
    }

    public void createPayment(String paymentId, String type, String bank) {
        appendChange(new PaymentCreated(paymentId, type, bank)).apply();
    }

    public void createShippingOrder(String shippingOrderId, LocalDate date, String price, LocalDateTime shippingTime) {
        appendChange(new ShippingOrderCreated(shippingOrderId, date, price, shippingTime)).apply();
    }

    public void addPayment(PaymentId paymentId, Type type, Bank bank, Recipe recipe) {
        appendChange(new PaymentAdded(paymentId.value(), type.value(), bank.value(), recipe)).apply();
    }

    public void addShippingOrder(ShippingOrderId shippingOrderId, Date date, Price price, ShippingTime shippingTime, State state) {
        appendChange(new ShippingOrderAdded(shippingOrderId.value(), date.value(), price.value(), shippingTime.value(), state.value())).apply();
    }

    public void changeShippingOrderState(SaleId saleId, ShippingOrderId shippingOrderId, State state) {
        appendChange(new ShippingOrderStateChanged(saleId.value(), shippingOrderId.value(), state.value())).apply();
    }
}
