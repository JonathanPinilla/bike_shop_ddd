package co.com.sofkau.business.commons;

import co.com.sofkau.generic.DomainEvent;

import java.util.List;

public interface EventsRepository {

    DomainEvent saveEvent(DomainEvent event);

    List<DomainEvent> findByAggregateRootId(String aggregateRootId);
}
