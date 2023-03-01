package co.com.sofkau.domain.ArSale.commands;

import co.com.sofkau.domain.ArSale.Payment;
import co.com.sofkau.domain.common.Id;
import co.com.sofkau.generic.Command;

public class AddPaymentToSale extends Command {

    private final Id saleId;
    private final Payment payment;

    public AddPaymentToSale(Id saleId, Payment payment) {
        this.saleId = saleId;
        this.payment = payment;
    }

    public Id getSaleId() {
        return saleId;
    }

    public Payment getPayment() {
        return payment;
    }
}
