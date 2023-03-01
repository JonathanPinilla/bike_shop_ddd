package co.com.sofkau.domain.common;

import co.com.sofkau.generic.Identity;

public class PaymentId extends Identity {

        private PaymentId(String uuid) {
            super(uuid);
        }

        public PaymentId() {
        }

        public static PaymentId of(String uuid) {
            return new PaymentId(uuid);
        }
}
