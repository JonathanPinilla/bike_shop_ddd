package co.com.sofkau.domain.common;

import co.com.sofkau.generic.Identity;

public class SaleId extends Identity {

    private SaleId(String uuid) {
        super(uuid);
    }

    public SaleId() {
    }

    public static SaleId of(String uuid) {
        return new SaleId(uuid);
    }
}
