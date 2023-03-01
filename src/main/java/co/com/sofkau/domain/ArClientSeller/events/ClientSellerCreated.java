package co.com.sofkau.domain.ArClientSeller.events;

import co.com.sofkau.domain.common.Date;
import co.com.sofkau.generic.DomainEvent;

public class ClientSellerCreated extends DomainEvent {
    private final Date creationDate;

    public ClientSellerCreated(Date creationDate) {
        super("co.com.sofkau.ArClientSeller");
        this.creationDate = creationDate;
    }

    public Date getCreationDate() {
        return creationDate;
    }
}
