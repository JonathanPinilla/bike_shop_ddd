package co.com.sofkau.domain.saleAR.values;

import co.com.sofkau.domain.common.Id;
import co.com.sofkau.generic.ValueObject;

public class Seller implements ValueObject<Id> {
    private Id sellerId;

    public Seller(Id sellerId) {
        this.sellerId = sellerId;
    }

    @Override
    public Id value() {
        return sellerId;
    }
}
