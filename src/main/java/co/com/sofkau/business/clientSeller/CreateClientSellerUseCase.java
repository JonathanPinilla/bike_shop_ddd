package co.com.sofkau.business.clientSeller;

import co.com.sofkau.business.commons.EventsRepository;
import co.com.sofkau.business.commons.UseCaseCommand;
import co.com.sofkau.domain.ArClientSeller.ClientSellerManager;
import co.com.sofkau.domain.ArClientSeller.commands.CreateClientSellerManager;
import co.com.sofkau.domain.common.ClientSellerManagerId;
import co.com.sofkau.domain.common.Date;
import co.com.sofkau.generic.DomainEvent;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class CreateClientSellerUseCase implements UseCaseCommand<CreateClientSellerManager> {

    EventsRepository eventsRepository;

    public CreateClientSellerUseCase(EventsRepository eventsRepository) {
        this.eventsRepository = eventsRepository;
    }

    @Override
    public List<DomainEvent> apply(CreateClientSellerManager command) {
        List<DomainEvent> events = eventsRepository.findByAggregateRootId(command.getClientSellerId());

        var clientSeller = new ClientSellerManager(
                ClientSellerManagerId.of(command.getClientSellerId()),
                command.getCreationDate()
        );

        return clientSeller.getUncommittedChanges().stream().map(eventsRepository::saveEvent).toList();
    }
}
