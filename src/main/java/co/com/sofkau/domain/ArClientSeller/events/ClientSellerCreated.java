package co.com.sofkau.domain.ArClientSeller.events;

import co.com.sofkau.generic.DomainEvent;

import java.time.LocalDate;

public class ClientSellerCreated extends DomainEvent {

    LocalDate creationDate;
    public ClientSellerCreated(LocalDate creationDate){
        super("co.com.sofkau.ArClientSeller");
        this.creationDate = creationDate;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

}
