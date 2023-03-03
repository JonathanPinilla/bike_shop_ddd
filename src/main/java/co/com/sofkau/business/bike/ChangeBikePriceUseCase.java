package co.com.sofkau.business.bike;

import co.com.sofkau.business.commons.EventsRepository;
import co.com.sofkau.business.commons.UseCaseCommand;
import co.com.sofkau.domain.ArBikeM.BikesManagement;
import co.com.sofkau.domain.ArBikeM.commands.ChangeBikePriceCommand;
import co.com.sofkau.domain.common.BikeId;
import co.com.sofkau.domain.common.BikesManagementId;
import co.com.sofkau.domain.common.Price;
import co.com.sofkau.generic.DomainEvent;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ChangeBikePriceUseCase implements UseCaseCommand<ChangeBikePriceCommand> {

    EventsRepository eventsRepository;

    public ChangeBikePriceUseCase(EventsRepository eventsRepository) {
        this.eventsRepository = eventsRepository;
    }

    @Override
    public List<DomainEvent> apply(ChangeBikePriceCommand command) {
        List<DomainEvent> events = eventsRepository.findByAggregateRootId(command.getBikeManagerId());
        var bikeManager = BikesManagement.from(
                BikesManagementId.of(command.getBikeManagerId()),
                events
        );

        bikeManager.changeBikePrice(
                BikeId.of(command.getBikeId()),
                new Price(command.getPrice())
        );

        return bikeManager.getUncommittedChanges().stream().map(eventsRepository::saveEvent).toList();
    }
}
