package co.com.sofkau.business.bike;

import co.com.sofkau.business.commons.EventsRepository;
import co.com.sofkau.business.commons.UseCaseCommand;
import co.com.sofkau.domain.ArBikeM.BikesManagement;
import co.com.sofkau.domain.ArBikeM.commands.CreateBikeManagerCommand;
import co.com.sofkau.domain.common.BikesManagementId;
import co.com.sofkau.domain.common.Date;
import co.com.sofkau.generic.DomainEvent;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class CreateBikeManagerUseCase implements UseCaseCommand<CreateBikeManagerCommand> {

    EventsRepository eventsRepository;

    public CreateBikeManagerUseCase(EventsRepository eventsRepository) {
        this.eventsRepository = eventsRepository;
    }

    @Override
    public List<DomainEvent> apply(CreateBikeManagerCommand command) {
        var bikerManager = new BikesManagement(
                BikesManagementId.of(command.getBikeManagerId()),
                new Date(LocalDate.now())
        );
        return bikerManager.getUncommittedChanges().stream().map(eventsRepository::saveEvent).toList();
    }
}
