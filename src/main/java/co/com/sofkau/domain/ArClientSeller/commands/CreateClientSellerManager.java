package co.com.sofkau.domain.ArClientSeller.commands;

import co.com.sofkau.generic.Command;

public class CreateClientSellerManager extends Command {
    private String clientSellerId;

    public CreateClientSellerManager(String clientSellerId) {
        this.clientSellerId = clientSellerId;
    }

    public String getClientSellerId() {
        return clientSellerId;
    }

    public void setClientSellerId(String clientSellerId) {
        this.clientSellerId = clientSellerId;
    }
}
