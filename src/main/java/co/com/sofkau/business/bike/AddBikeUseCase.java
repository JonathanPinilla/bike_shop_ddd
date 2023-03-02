package co.com.sofkau.business.bike;

import co.com.sofkau.business.commons.EventsRepository;
import co.com.sofkau.business.commons.UseCaseCommand;
import co.com.sofkau.domain.ArBikeM.BikesManagement;
import co.com.sofkau.domain.ArBikeM.commands.AddBikeToManager;
import co.com.sofkau.domain.common.BikesManagementId;
import co.com.sofkau.generic.DomainEvent;

import java.util.List;

public class AddBikeUseCase implements UseCaseCommand<AddBikeToManager> {

    EventsRepository eventsRepository;

    public AddBikeUseCase(EventsRepository eventsRepository) {
        this.eventsRepository = eventsRepository;
    }

    @Override
    public List<DomainEvent> apply(AddBikeToManager command) {
        List<DomainEvent> events = eventsRepository.findByAggregateRootId(command.getBikeManagerId());
        var bikeManager = BikesManagement.from(
                BikesManagementId.of(command.getBikeManagerId()),
                events
        );
        bikeManager.addBike(
                command.getBikeId(),
                command.getBrand(),
                command.getUsage(),
                command.getUsage(),
                command.getPrice(),
                command.getSold()
        );
        return bikeManager.getUncommittedChanges().stream().map(eventsRepository::saveEvent).toList();
    }
}
