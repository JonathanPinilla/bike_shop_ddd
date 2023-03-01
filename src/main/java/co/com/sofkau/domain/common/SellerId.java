package co.com.sofkau.domain.common;

import co.com.sofkau.generic.Identity;

public class SellerId extends Identity {

    private SellerId(String uuid) {
        super(uuid);
    }

    public SellerId() {
    }

    public static SellerId of(String uuid) {
        return new SellerId(uuid);
    }
}
