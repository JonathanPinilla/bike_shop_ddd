package co.com.sofkau.domain.ArClientSeller;

import co.com.sofkau.domain.ArClientSeller.events.*;
import co.com.sofkau.domain.ArClientSeller.values.Address;
import co.com.sofkau.domain.ArClientSeller.values.Charge;
import co.com.sofkau.domain.ArClientSeller.values.Lname;
import co.com.sofkau.domain.common.ClientId;
import co.com.sofkau.domain.common.Name;
import co.com.sofkau.domain.common.SellerId;
import co.com.sofkau.generic.EventChange;

public class ClientSellerManagerEventChange extends EventChange {
public ClientSellerManagerEventChange(ClientSellerManager clientSellerManager) {
        apply((ClientSellerCreated event) -> {
            clientSellerManager.creationDate = event.getCreationDate();
        });
        apply((ClientAdded event) -> {
            Client client = new Client(
                    ClientId.of(event.getClientId()),
                    new Name(event.getName()),
                    new Lname(event.getLname()),
                    new Address(event.getAddress()),
                    null
                    );
            clientSellerManager.clientList.add(client);
        });
        apply((SellerAdded event) -> {
            Seller seller = new Seller(
                    SellerId.of(event.getSellerId()),
                    new Name(event.getName()),
                    new Lname(event.getLname()),
                    new Charge(event.getCharge())
            );
            clientSellerManager.sellerList.add(seller);
        });
    }
}
