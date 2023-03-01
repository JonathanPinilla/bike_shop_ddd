package co.com.sofkau.domain.ArSale;

import co.com.sofkau.domain.ArSale.events.*;
import co.com.sofkau.domain.ArSale.values.*;
import co.com.sofkau.domain.common.*;
import co.com.sofkau.generic.AggregateRoot;
import co.com.sofkau.generic.DomainEvent;

import java.util.List;

public class Sale extends AggregateRoot<SaleId> {


    protected Client client;
    protected Seller seller;
    protected Payment payment;
    protected ShippingOrder shippingOrder;

    public Sale(SaleId saleId, Client client, Seller seller, Payment payment, ShippingOrder shippingOrder) {
        super(saleId);
        subscribe(new SaleEventChange(this));
        appendChange(new SaleCreated(client,seller));
    }

    public Sale(SaleId saleId){
        super(saleId);
        subscribe( new SaleEventChange(this));
    }

    public static Sale from(SaleId saleId, List<DomainEvent> events){
        var sale = new Sale(saleId);
        events.forEach(sale::applyEvent);
        return sale;
    }

    public void createPayment(PaymentId paymentId, Type type, Bank bank){
        appendChange(new PaymentCreated(paymentId, type, bank)).apply();
    }

    public void createShippingOrder(ShippingOrderId shippingOrderId, Date date, Price price, ShippingTime shippingTime){
        appendChange(new ShippingOrderCreated(shippingOrderId, date, price, shippingTime)).apply();
    }

    public void addPayment(Payment payment){
        appendChange(new PaymentAdded(payment)).apply();
    }

    public void addShippingOrder(ShippingOrder shippingOrder){
        appendChange(new ShippingOrderAdded(shippingOrder)).apply();
    }
}
