package co.com.sofkau.domain.common;

import co.com.sofkau.generic.Identity;

public class BikesManagementId extends Identity {

        private BikesManagementId(String uuid) {
            super(uuid);
        }

        public BikesManagementId() {
        }

        public static BikesManagementId of(String uuid) {
            return new BikesManagementId(uuid);
        }
}
