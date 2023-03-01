package co.com.sofkau.domain.ArClientSeller.commands;

import co.com.sofkau.generic.Command;

public class AddSellerToManager extends Command {

    private final String clientSellerId;
    private final String sellerId;

    public AddSellerToManager(String clientSellerId, String sellerId) {
        this.clientSellerId = clientSellerId;
        this.sellerId = sellerId;
    }

    public String getClientSellerId() {
        return clientSellerId;
    }

    public String getSellerId() {
        return sellerId;
    }
}
