package co.com.sofkau.domain.ArSale.events;

import co.com.sofkau.domain.ArSale.Payment;
import co.com.sofkau.generic.DomainEvent;

public class PaymentAdded extends DomainEvent {

    private final Payment payment;

    public PaymentAdded(Payment paymentId) {
        super("co.com.sofkau.ArSale.Payment.added");
        this.payment = paymentId;
    }

    public Payment getPayment() {
        return payment;
    }
}
