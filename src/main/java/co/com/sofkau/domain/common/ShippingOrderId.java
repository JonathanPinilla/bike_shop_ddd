package co.com.sofkau.domain.common;

import co.com.sofkau.generic.Identity;

public class ShippingOrderId extends Identity {

    private ShippingOrderId(String uuid) {
        super(uuid);
    }

    public ShippingOrderId() {
    }

    public static ShippingOrderId of(String uuid) {
        return new ShippingOrderId(uuid);
    }
}
