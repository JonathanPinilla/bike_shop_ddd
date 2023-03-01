package co.com.sofkau.domain.ArSale.events;

import co.com.sofkau.generic.DomainEvent;

public class PaymentCreated extends DomainEvent {

    private final String paymentId;
    private final String type;
    private final String bank;

    public PaymentCreated(String paymentId,String type, String bank) {
        super("co.com.sofkau.ArSale.Payment.created");
        this.paymentId = paymentId;
        this.type = type;
        this.bank = bank;
    }

    public String getType() {
        return type;
    }

    public String getBank() {
        return bank;
    }
}
