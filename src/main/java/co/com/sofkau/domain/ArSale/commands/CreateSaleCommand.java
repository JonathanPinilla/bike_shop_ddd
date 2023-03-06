package co.com.sofkau.domain.ArSale.commands;

import co.com.sofkau.generic.Command;

public class CreateSaleCommand extends Command {
    private String saleId;
    private String clientId;
    private String sellerId;

    public CreateSaleCommand(String saleId, String clientId, String sellerId) {
        this.saleId = saleId;
        this.clientId = clientId;
        this.sellerId = sellerId;
    }

    public String getSaleId() {
        return saleId;
    }

    public void setSaleId(String saleId) {
        this.saleId = saleId;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getSellerId() {
        return sellerId;
    }

    public void setSellerId(String sellerId) {
        this.sellerId = sellerId;
    }
}
