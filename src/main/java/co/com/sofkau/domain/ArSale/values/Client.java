package co.com.sofkau.domain.ArSale.values;

import co.com.sofkau.domain.common.Id;
import co.com.sofkau.generic.ValueObject;

public class Client implements ValueObject<Id> {
    private Id clientId;

    public Client(Id clientId) {
        this.clientId = clientId;
    }

    @Override
    public Id value() {
        return clientId;
    }
}
