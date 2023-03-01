package co.com.sofkau.domain.ArClientSeller.values;

import co.com.sofkau.domain.common.Id;

public class Sale {
    private Id saleId;

    public Sale(Id saleId) {
        this.saleId = saleId;
    }

    public Id getSaleId() {
        return saleId;
    }
}
