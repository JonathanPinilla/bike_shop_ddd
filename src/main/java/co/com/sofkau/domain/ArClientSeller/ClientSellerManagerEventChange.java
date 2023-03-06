package co.com.sofkau.domain.ArClientSeller;

import co.com.sofkau.domain.ArClientSeller.events.*;
import co.com.sofkau.domain.ArClientSeller.values.Address;
import co.com.sofkau.domain.ArClientSeller.values.Charge;
import co.com.sofkau.domain.ArClientSeller.values.CreditCard;
import co.com.sofkau.domain.ArClientSeller.values.Lname;
import co.com.sofkau.domain.common.*;
import co.com.sofkau.generic.EventChange;

import java.time.LocalDate;
import java.util.ArrayList;

public class ClientSellerManagerEventChange extends EventChange {
public ClientSellerManagerEventChange(ClientSellerManager clientSellerManager) {
        apply((ClientSellerCreated event) -> {
            clientSellerManager.creationDate = new Date(event.getCreationDate());
            clientSellerManager.clientList = new ArrayList<>();
            clientSellerManager.sellerList = new ArrayList<>();
        });
        apply((ClientAdded event) -> {
            Client client = new Client(
                    ClientId.of(event.getClientId()),
                    new Name(event.getName()),
                    new Lname(event.getLname()),
                    new Address(event.getAddress()),
                    new CreditCard()
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
        apply((ClientAddressChanged event) -> {
            clientSellerManager.clientList.stream()
                    .filter(client -> client.identity().value().equals(event.getClientId()))
                    .forEach(client -> client.changeAddress(new Address(event.getAddress())));
        });
    }
}
