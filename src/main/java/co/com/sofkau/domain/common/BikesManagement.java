package co.com.sofkau.domain.common;

import co.com.sofkau.generic.Identity;

public class BikesManagement extends Identity {

        private BikesManagement(String uuid) {
            super(uuid);
        }

        public BikesManagement() {
        }

        public static BikesManagement of(String uuid) {
            return new BikesManagement(uuid);
        }
}
