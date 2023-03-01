package co.com.sofkau.domain.ArSale;

import co.com.sofkau.domain.ArSale.events.PaymentAdded;
import co.com.sofkau.domain.ArSale.events.SaleCreated;
import co.com.sofkau.domain.ArSale.events.ShippingOrderAdded;
import co.com.sofkau.generic.EventChange;

public class SaleEventChange extends EventChange {
    public SaleEventChange(Sale sale){
        apply((SaleCreated event) -> {
            sale.client = event.getClient();
            sale.seller = event.getSeller();
        });
        apply((PaymentAdded event) -> {
            sale.payment = event.getPayment();
        });
        apply((ShippingOrderAdded event) -> {
            sale.shippingOrder = event.getShippingOrder();
        });
    }

}
