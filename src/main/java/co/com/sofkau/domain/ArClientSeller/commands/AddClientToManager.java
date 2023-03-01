package co.com.sofkau.domain.ArClientSeller.commands;

import co.com.sofkau.generic.Command;

public class AddClientToManager extends Command {

    private final String clientSellerId;
    private final String clientId;

    public AddClientToManager(String clientSellerId, String clientId) {
        this.clientSellerId = clientSellerId;
        this.clientId = clientId;
    }

    public String getClientSellerId() {
        return clientSellerId;
    }

    public String getClientId() {
        return clientId;
    }
}
