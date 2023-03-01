package co.com.sofkau.domain.ArClientSeller;

import co.com.sofkau.domain.ArClientSeller.events.ClientCreated;
import co.com.sofkau.domain.ArClientSeller.events.ClientSellerCreated;
import co.com.sofkau.domain.ArClientSeller.events.SellerCreated;
import co.com.sofkau.generic.EventChange;

public class ClientSellerManagerEventChange extends EventChange {
public ClientSellerManagerEventChange(ClientSellerManager clientSellerManager) {
        apply((ClientSellerCreated event) -> {
            clientSellerManager.creationDate = event.getCreationDate();
        });
        apply((ClientCreated event) -> {
            clientSellerManager.createClient(event.getName(),event.getLname(), event.getAddress());
        });
        apply((SellerCreated event) -> {
            clientSellerManager.createSeller(event.getName(),event.getLname(), event.getCharge());
        });
    }
}
