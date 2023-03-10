package co.com.sofkau.domain.ArSale;

import co.com.sofkau.domain.common.BikeId;
import co.com.sofkau.domain.common.PaymentId;
import co.com.sofkau.domain.ArSale.values.Bank;
import co.com.sofkau.domain.ArSale.values.Recipe;

import co.com.sofkau.domain.common.Type;
import co.com.sofkau.generic.Entity;


public class Payment extends Entity<PaymentId> {

    protected Type type;
    protected Bank bank;
    protected Recipe recipe;

    public Payment(PaymentId paymentId, Type type, Bank bank, Recipe recipe) {
        super(paymentId);
        this.type = type;
        this.bank = bank;
        this.recipe = recipe;
    }

    public Type type() {
        return type;
    }

    public Bank bank() {
        return bank;
    }

    public Recipe recipe() {
        return recipe;
    }

}
