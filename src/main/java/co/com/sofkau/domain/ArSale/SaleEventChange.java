package co.com.sofkau.domain.ArSale;

import co.com.sofkau.domain.ArSale.events.PaymentAdded;
import co.com.sofkau.domain.ArSale.events.SaleCreated;
import co.com.sofkau.domain.ArSale.events.ShippingOrderAdded;
import co.com.sofkau.domain.ArSale.values.Bank;
import co.com.sofkau.domain.ArSale.values.ShippingTime;
import co.com.sofkau.domain.ArSale.values.State;
import co.com.sofkau.domain.common.*;
import co.com.sofkau.generic.EventChange;

public class SaleEventChange extends EventChange {
    public SaleEventChange(Sale sale) {
        apply((SaleCreated event) -> {
            sale.client = ClientId.of(event.getClient());
            sale.seller = SellerId.of(event.getSeller());
        });
        apply((PaymentAdded event) -> {
            sale.payment = new Payment(
                    PaymentId.of(event.getPaymentId()),
                    new Type(event.getType()),
                    new Bank(event.getBank()),
                    event.getRecipe()
            );
        });
        apply((ShippingOrderAdded event) -> {
            sale.shippingOrder = new ShippingOrder(ShippingOrderId.of(
                    event.getShippingOrderId()),
                    new Date(event.getDate()),
                    new Price(event.getPrice()),
                    new ShippingTime(event.getShippingTime()),
                    new State(event.getState())
            );
        });
    }

}
