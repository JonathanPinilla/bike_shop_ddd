package co.com.sofkau.domain.ArSale.commands;

import co.com.sofkau.domain.ArSale.ShippingOrder;
import co.com.sofkau.generic.Command;

public class AddShippingOrderToSale extends Command {

    private final String saleId;
    private final ShippingOrder shippingOrder;

    public AddShippingOrderToSale(String saleId, ShippingOrder shippingOrder) {
        this.saleId = saleId;
        this.shippingOrder = shippingOrder;
    }

    public String getSaleId() {
        return saleId;
    }

    public ShippingOrder getShippingOrder() {
        return shippingOrder;
    }
}
