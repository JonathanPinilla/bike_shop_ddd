package co.com.sofkau.business.clientSeller;

import co.com.sofkau.business.commons.EventsRepository;
import co.com.sofkau.business.commons.UseCaseCommand;
import co.com.sofkau.domain.ArClientSeller.ClientSellerManager;
import co.com.sofkau.domain.ArClientSeller.commands.AddClientToManager;
import co.com.sofkau.domain.ArClientSeller.values.Address;
import co.com.sofkau.domain.ArClientSeller.values.Lname;
import co.com.sofkau.domain.common.ClientId;
import co.com.sofkau.domain.common.ClientSellerManagerId;
import co.com.sofkau.domain.common.Name;
import co.com.sofkau.generic.DomainEvent;

import java.util.List;

public class AddClientUseCase implements UseCaseCommand<AddClientToManager>{

    EventsRepository eventsRepository;

    public AddClientUseCase(EventsRepository eventsRepository) {
        this.eventsRepository = eventsRepository;
    }

    @Override
    public List<DomainEvent> apply(AddClientToManager command) {
        List<DomainEvent> events = eventsRepository.findByAggregateRootId(command.getClientSellerId());
        var clientSeller = ClientSellerManager.from(
                ClientSellerManagerId.of(command.getClientSellerId()),
                events
        );
        clientSeller.addClient(
                ClientId.of(command.getClientId()),
                new Name(command.getName()),
                new Lname(command.getLname()),
                new Address(command.getAddress())
        );
        return clientSeller.getUncommittedChanges().stream().map(eventsRepository::saveEvent).toList();
    }
}
