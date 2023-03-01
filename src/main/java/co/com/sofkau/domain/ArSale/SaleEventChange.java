package co.com.sofkau.domain.ArSale;

import co.com.sofkau.domain.ArSale.events.PaymentAdded;
import co.com.sofkau.domain.ArSale.events.SaleCreated;
import co.com.sofkau.domain.ArSale.events.ShippingOrderAdded;
import co.com.sofkau.domain.common.ClientId;
import co.com.sofkau.domain.common.SellerId;
import co.com.sofkau.generic.EventChange;

public class SaleEventChange extends EventChange {
    public SaleEventChange(Sale sale) {
        apply((SaleCreated event) -> {
            sale.client = ClientId.of(event.getClient());
            sale.seller = SellerId.of(event.getSeller());
        });
        apply((PaymentAdded event) -> {
            sale.addPayment(event.getPaymentId(), event.getType(), event.getBank(), event.getRecipe());
        });
        apply((ShippingOrderAdded event) -> {
            sale.addShippingOrder(event.getShippingOrderId(), event.getDate(), event.getPrice(), event.getShippingTime(), event.getState());
        });
    }

}
