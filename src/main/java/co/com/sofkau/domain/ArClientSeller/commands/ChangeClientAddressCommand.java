package co.com.sofkau.domain.ArClientSeller.commands;

import co.com.sofkau.generic.Command;

public class ChangeClientAddressCommand extends Command {

    private final String clientSellerId;
    private final String clientId;
    private final String address;

    public ChangeClientAddressCommand(String clientSellerId, String clientId, String address) {
        this.clientSellerId = clientSellerId;
        this.clientId = clientId;
        this.address = address;
    }

    public String getClientSellerId() {
        return clientSellerId;
    }

    public String getClientId() {
        return clientId;
    }

    public String getAddress() {
        return address;
    }

}
