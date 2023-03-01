package co.com.sofkau.domain.saleAR.commands;

import co.com.sofkau.generic.Command;

public class AddSellerToSale extends Command {

    private final String saleId;
    private final String sellerId;

    public AddSellerToSale(String saleId, String sellerId) {
        this.saleId = saleId;
        this.sellerId = sellerId;
    }

    public String getSaleId() {
        return saleId;
    }

    public String getSellerId() {
        return sellerId;
    }
}
