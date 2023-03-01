package co.com.sofkau.domain.ArSale.commands;

import co.com.sofkau.generic.Command;

public class AddShippingOrderToSale extends Command {

    private final String saleId;
    private final String shippingOrderId;

    public AddShippingOrderToSale(String saleId, String shippingOrderId) {
        this.saleId = saleId;
        this.shippingOrderId = shippingOrderId;
    }

    public String getSaleId() {
        return saleId;
    }

    public String getShippingOrderId() {
        return shippingOrderId;
    }
}
