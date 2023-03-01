package co.com.sofkau.domain.saleAR.commands;

import co.com.sofkau.generic.Command;

public class AddClientToSale extends Command {

    private final String saleId;
    private final String clientId;

    public AddClientToSale(String saleId, String clientId) {
        this.saleId = saleId;
        this.clientId = clientId;
    }

    public String getSaleId() {
        return saleId;
    }

    public String getClientId() {
        return clientId;
    }
}
