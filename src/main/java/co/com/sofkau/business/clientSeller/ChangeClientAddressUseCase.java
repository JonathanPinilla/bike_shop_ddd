package co.com.sofkau.business.clientSeller;

import co.com.sofkau.business.commons.EventsRepository;
import co.com.sofkau.business.commons.UseCaseCommand;
import co.com.sofkau.domain.ArClientSeller.ClientSellerManager;
import co.com.sofkau.domain.ArClientSeller.commands.ChangeClientAddressCommand;
import co.com.sofkau.domain.ArClientSeller.values.Address;
import co.com.sofkau.domain.common.ClientId;
import co.com.sofkau.domain.common.ClientSellerManagerId;
import co.com.sofkau.generic.DomainEvent;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ChangeClientAddressUseCase implements UseCaseCommand<ChangeClientAddressCommand> {

    EventsRepository eventsRepository;

    public ChangeClientAddressUseCase(EventsRepository eventsRepository) {
        this.eventsRepository = eventsRepository;
    }

    @Override
    public List<DomainEvent> apply(ChangeClientAddressCommand command) {

        List<DomainEvent> events = eventsRepository.findByAggregateRootId(command.getClientSellerId());
        var clientSellerManager = ClientSellerManager.from(ClientSellerManagerId.of(command.getClientSellerId()), events);
        clientSellerManager.changeClientAddress(ClientId.of(command.getClientId()), new Address(command.getAddress()));

        return clientSellerManager.getUncommittedChanges().stream().map(eventsRepository::saveEvent).toList();

    }
}
