package co.com.sofkau.domain.common;

import co.com.sofkau.generic.Identity;

public class ClientId extends Identity {

    private ClientId(String uuid) {
        super(uuid);
    }

    public ClientId() {
    }

    public static ClientId of(String uuid) {
        return new ClientId(uuid);
    }
}
