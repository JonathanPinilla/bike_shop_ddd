package co.com.sofkau.business.commons;

import co.com.sofkau.generic.DomainEvent;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventsRepository {

    DomainEvent saveEvent(DomainEvent event);

    List<DomainEvent> findByAggregateRootId(String aggregateRootId);
}
