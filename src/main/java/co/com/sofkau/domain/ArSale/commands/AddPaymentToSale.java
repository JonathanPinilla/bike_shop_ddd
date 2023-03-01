package co.com.sofkau.domain.ArSale.commands;

import co.com.sofkau.generic.Command;

public class AddPaymentToSale extends Command {

    private final String saleId;
    private final String paymentId;

    public AddPaymentToSale(String saleId, String paymentId) {
        this.saleId = saleId;
        this.paymentId = paymentId;
    }

    public String getSaleId() {
        return saleId;
    }

    public String getPaymentId() {
        return paymentId;
    }
}
