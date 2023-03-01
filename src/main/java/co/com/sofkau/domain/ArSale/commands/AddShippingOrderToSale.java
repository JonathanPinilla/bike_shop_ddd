package co.com.sofkau.domain.ArSale.commands;

import co.com.sofkau.domain.ArSale.ShippingOrder;
import co.com.sofkau.domain.common.Id;
import co.com.sofkau.generic.Command;

public class AddShippingOrderToSale extends Command {

    private final Id saleId;
    private final ShippingOrder shippingOrder;

    public AddShippingOrderToSale(Id saleId, ShippingOrder shippingOrder) {
        this.saleId = saleId;
        this.shippingOrder = shippingOrder;
    }

    public Id getSaleId() {
        return saleId;
    }

    public ShippingOrder getShippingOrder() {
        return shippingOrder;
    }
}
