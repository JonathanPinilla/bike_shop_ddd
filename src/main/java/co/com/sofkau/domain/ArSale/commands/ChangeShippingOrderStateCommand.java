package co.com.sofkau.domain.ArSale.commands;

import co.com.sofkau.generic.Command;

public class ChangeShippingOrderStateCommand extends Command {

    private final String saleId;
    private final String shippingOrderId;
    private final String state;

    public ChangeShippingOrderStateCommand(String saleId, String shippingOrderId, String state) {
        this.saleId = saleId;
        this.shippingOrderId = shippingOrderId;
        this.state = state;
    }

    public String saleId() {
        return saleId;
    }

    public String shippingOrderId() {
        return shippingOrderId;
    }

    public String state() {
        return state;
    }
}
