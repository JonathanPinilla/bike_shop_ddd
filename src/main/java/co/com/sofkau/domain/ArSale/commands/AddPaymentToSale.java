package co.com.sofkau.domain.ArSale.commands;

import co.com.sofkau.domain.ArSale.Payment;
import co.com.sofkau.domain.ArSale.values.Recipe;
import co.com.sofkau.generic.Command;

public class AddPaymentToSale extends Command {

    private final String saleId;
    private final String paymentId;
    private final String type;
    private final String bank;
    private final Recipe recipe;

    public AddPaymentToSale(String saleId, String paymentId, String type, String bank, Recipe recipe) {
        this.saleId = saleId;
        this.paymentId = paymentId;
        this.type = type;
        this.bank = bank;
        this.recipe = recipe;
    }

    public String getSaleId() {
        return saleId;
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
