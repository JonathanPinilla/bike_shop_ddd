package co.com.sofkau.domain.ArClientSeller;

import co.com.sofkau.domain.ArClientSeller.ClientSellerManager;
import co.com.sofkau.domain.ArClientSeller.events.ClientSellerCreated;
import co.com.sofkau.generic.EventChange;

public class ClientSellerManagerEventChange extends EventChange {
public ClientSellerManagerEventChange(ClientSellerManager clientSellerManager) {
        apply((ClientSellerCreated event) -> {
            clientSellerManager.creationDate = event.getCreationDate();
        });
    }
}
