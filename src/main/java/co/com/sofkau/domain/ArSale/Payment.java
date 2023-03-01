package co.com.sofkau.domain.ArSale;

import co.com.sofkau.domain.common.Id;
import co.com.sofkau.domain.common.Type;
import co.com.sofkau.domain.ArSale.values.Bank;
import co.com.sofkau.domain.ArSale.values.Recipe;

import co.com.sofkau.generic.Entity;

import java.util.Objects;


public class Payment extends Entity<Id> {

    protected Type type;
    protected Bank bank;
    protected Recipe recipe;

    public Payment(Id id, Type type, Bank bank, Recipe recipe) {
        super(id);
        this.type = type;
        this.bank = bank;
        this.recipe = recipe;
    }

    public boolean checkBankAndType(Bank bank, Type type) {
        return (Objects.nonNull(bank) && Objects.nonNull(type));
    }

    public void updateRecipeBikes(Id bikeId) {
        this.recipe.addBike(bikeId);
    }

}
