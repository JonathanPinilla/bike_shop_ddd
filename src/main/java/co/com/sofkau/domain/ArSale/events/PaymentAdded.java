package co.com.sofkau.domain.ArSale.events;

import co.com.sofkau.domain.ArSale.Payment;
import co.com.sofkau.domain.ArSale.values.Bank;
import co.com.sofkau.domain.ArSale.values.Recipe;
import co.com.sofkau.domain.common.PaymentId;
import co.com.sofkau.generic.DomainEvent;

public class PaymentAdded extends DomainEvent {

    private final String paymentId;
    private final String type;
    private final String bank;
    private final Recipe recipe;

    public PaymentAdded(String paymentId, String type, String bank, Recipe recipe) {
        super("co.com.sofkau.ArSale.Payment.added");
        this.paymentId = paymentId;
        this.type = type;
        this.bank = bank;
        this.recipe = recipe;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public String getType() {
        return type;
    }

    public String getBank() {
        return bank;
    }

    public Recipe getRecipe() {
        return recipe;
    }

}
