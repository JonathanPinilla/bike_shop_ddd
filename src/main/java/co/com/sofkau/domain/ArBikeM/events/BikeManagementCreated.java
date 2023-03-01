package co.com.sofkau.domain.ArBikeM.events;

import co.com.sofkau.domain.common.Date;
import co.com.sofkau.domain.common.Id;
import co.com.sofkau.generic.DomainEvent;

public class BikeManagementCreated extends DomainEvent {

    private final Date creationDate;

    public BikeManagementCreated(Date creationDate) {
        super("co.com.sofkau.ArBikeM.BikeManagement.created");
        this.creationDate = creationDate;
    }

    public Date getCreationDate() {
        return creationDate;
    }
}
