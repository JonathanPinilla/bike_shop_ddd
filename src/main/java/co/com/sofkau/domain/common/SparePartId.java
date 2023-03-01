package co.com.sofkau.domain.common;

import co.com.sofkau.generic.Identity;

public class SparePartId extends Identity {

    private SparePartId(String uuid) {
        super(uuid);
    }

    public SparePartId() {
    }

    public static SparePartId of(String uuid) {
        return new SparePartId(uuid);
    }
}
