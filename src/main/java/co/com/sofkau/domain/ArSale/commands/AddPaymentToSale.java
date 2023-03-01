package co.com.sofkau.domain.ArSale.commands;

import co.com.sofkau.domain.ArSale.Payment;
import co.com.sofkau.generic.Command;

public class AddPaymentToSale extends Command {

    private final String saleId;
    private final Payment payment;

    public AddPaymentToSale(String saleId, Payment payment) {
        this.saleId = saleId;
        this.payment = payment;
    }

    public String getSaleId() {
        return saleId;
    }

    public Payment getPayment() {
        return payment;
    }
}
