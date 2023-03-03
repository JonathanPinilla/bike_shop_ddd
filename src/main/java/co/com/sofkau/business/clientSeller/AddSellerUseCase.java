package co.com.sofkau.business.clientSeller;

import co.com.sofkau.business.commons.EventsRepository;
import co.com.sofkau.business.commons.UseCaseCommand;
import co.com.sofkau.domain.ArClientSeller.ClientSellerManager;
import co.com.sofkau.domain.ArClientSeller.Seller;
import co.com.sofkau.domain.ArClientSeller.commands.AddSellerToManager;
import co.com.sofkau.domain.ArClientSeller.values.Charge;
import co.com.sofkau.domain.ArClientSeller.values.Lname;
import co.com.sofkau.domain.common.ClientSellerManagerId;
import co.com.sofkau.domain.common.Name;
import co.com.sofkau.domain.common.SellerId;
import co.com.sofkau.generic.DomainEvent;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AddSellerUseCase implements UseCaseCommand<AddSellerToManager> {

    EventsRepository eventsRepository;

    public AddSellerUseCase(EventsRepository eventsRepository) {
        this.eventsRepository = eventsRepository;
    }

    @Override
    public List<DomainEvent> apply(AddSellerToManager command) {
        List<DomainEvent> events = eventsRepository.findByAggregateRootId(command.getClientSellerId());
        var clientSeller = ClientSellerManager.from(
                ClientSellerManagerId.of(command.getClientSellerId()),
                events
        );
        clientSeller.addSeller(
                SellerId.of(command.getSellerId()),
                new Name(command.getName()),
                new Lname(command.getLname()),
                new Charge(command.getCharge())
        );
        return clientSeller.getUncommittedChanges().stream().map(eventsRepository::saveEvent).toList();
    }
}
