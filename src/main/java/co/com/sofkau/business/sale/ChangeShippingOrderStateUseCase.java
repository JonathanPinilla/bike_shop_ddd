package co.com.sofkau.business.sale;

import co.com.sofkau.business.commons.EventsRepository;
import co.com.sofkau.business.commons.UseCaseCommand;
import co.com.sofkau.domain.ArSale.Sale;
import co.com.sofkau.domain.ArSale.commands.ChangeShippingOrderStateCommand;
import co.com.sofkau.domain.ArSale.values.State;
import co.com.sofkau.domain.common.SaleId;
import co.com.sofkau.domain.common.ShippingOrderId;
import co.com.sofkau.generic.DomainEvent;

import java.util.List;

public class ChangeShippingOrderStateUseCase implements UseCaseCommand<ChangeShippingOrderStateCommand> {

    EventsRepository eventsRepository;

    public ChangeShippingOrderStateUseCase(EventsRepository eventsRepository) {
        this.eventsRepository = eventsRepository;
    }

    @Override
    public List<DomainEvent> apply(ChangeShippingOrderStateCommand command) {
        List<DomainEvent> events = eventsRepository.findByAggregateRootId(command.saleId());
        var sale = Sale.from(SaleId.of(command.saleId()), events);
        sale.changeShippingOrderState(SaleId.of(command.saleId()), ShippingOrderId.of(command.shippingOrderId()), new State(command.state()));

        return sale.getUncommittedChanges().stream().map(eventsRepository::saveEvent).toList();
    }
}
