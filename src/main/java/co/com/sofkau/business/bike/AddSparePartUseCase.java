package co.com.sofkau.business.bike;

import co.com.sofkau.business.commons.EventsRepository;
import co.com.sofkau.business.commons.UseCaseCommand;
import co.com.sofkau.domain.ArBikeM.BikesManagement;
import co.com.sofkau.domain.ArBikeM.commands.AddSparePartToManager;
import co.com.sofkau.domain.common.BikesManagementId;
import co.com.sofkau.generic.DomainEvent;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AddSparePartUseCase implements UseCaseCommand<AddSparePartToManager> {

    private final EventsRepository eventsRepository;

    public AddSparePartUseCase(EventsRepository eventsRepository) {
        this.eventsRepository = eventsRepository;
    }

    @Override
    public List<DomainEvent> apply(AddSparePartToManager command) {
        List<DomainEvent> events = eventsRepository.findByAggregateRootId(command.getBikeManagerId());
        var bikeManager = BikesManagement.from(
                BikesManagementId.of(command.getBikeManagerId()),
                events
        );
        bikeManager.addSparePart(
                command.getSparePartId(),
                command.getName(),
                command.getReference(),
                command.getUsage(),
                command.getPrice()
        );
        return bikeManager.getUncommittedChanges().stream().map(eventsRepository::saveEvent).toList();
    }
}
