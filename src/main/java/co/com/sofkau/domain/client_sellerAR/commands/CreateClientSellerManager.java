package co.com.sofkau.domain.client_sellerAR.commands;

import co.com.sofkau.generic.Command;

public class CreateClientSellerManager extends Command {
    private final String clientSellerId;

    public CreateClientSellerManager(String clientSellerId) {
        this.clientSellerId = clientSellerId;
    }

    public String getClientSellerId() {
        return clientSellerId;
    }
}
