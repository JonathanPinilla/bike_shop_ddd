package co.com.sofkau.domain.ArSale.events;

import co.com.sofkau.domain.ArSale.values.Bank;
import co.com.sofkau.domain.common.PaymentId;
import co.com.sofkau.domain.common.Type;
import co.com.sofkau.generic.DomainEvent;

public class PaymentCreated extends DomainEvent {
    private final Type type;
    private final Bank bank;

    public PaymentCreated(PaymentId paymentId, Type type, Bank bank) {
        super("co.com.sofkau.ArSale.Payment.created");
        this.type = type;
        this.bank = bank;
    }

    public Type getType() {
        return type;
    }

    public Bank getBank() {
        return bank;
    }
}
