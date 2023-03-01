package co.com.sofkau.domain.common;

import co.com.sofkau.generic.Identity;

public class ClientSellerManagerId extends Identity {

    private ClientSellerManagerId(String uuid) {
        super(uuid);
    }

    public ClientSellerManagerId() {
    }

    public static ClientSellerManagerId of(String uuid) {
        return new ClientSellerManagerId(uuid);
    }
}
