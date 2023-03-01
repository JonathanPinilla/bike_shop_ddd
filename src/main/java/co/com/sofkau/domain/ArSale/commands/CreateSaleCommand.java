package co.com.sofkau.domain.ArSale.commands;

import co.com.sofkau.generic.Command;

public class CreateSaleCommand extends Command {
    private String saleId;
    private String client;
    private String seller;

    public String getSaleId() {
        return saleId;
    }

    public void setSaleId(String saleId) {
        this.saleId = saleId;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getSeller() {
        return seller;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }
}
