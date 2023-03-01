package co.com.sofkau.domain.common;

import co.com.sofkau.generic.Identity;

public class BikeId extends Identity {

    private BikeId(String uuid) {
        super(uuid);
    }

    public BikeId() {
    }

    public static BikeId of(String uuid) {
        return new BikeId(uuid);
    }
}
