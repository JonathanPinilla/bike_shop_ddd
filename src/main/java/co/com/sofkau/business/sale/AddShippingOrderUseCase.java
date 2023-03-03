package co.com.sofkau.business.sale;

import co.com.sofkau.business.commons.EventsRepository;
import co.com.sofkau.business.commons.UseCaseCommand;
import co.com.sofkau.domain.ArSale.Sale;
import co.com.sofkau.domain.ArSale.commands.AddShippingOrderToSale;
import co.com.sofkau.domain.ArSale.values.ShippingTime;
import co.com.sofkau.domain.ArSale.values.State;
import co.com.sofkau.domain.common.Date;
import co.com.sofkau.domain.common.Price;
import co.com.sofkau.domain.common.SaleId;
import co.com.sofkau.domain.common.ShippingOrderId;
import co.com.sofkau.generic.DomainEvent;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AddShippingOrderUseCase implements UseCaseCommand<AddShippingOrderToSale> {

    EventsRepository eventsRepository;

    public AddShippingOrderUseCase(EventsRepository eventsRepository) {
        this.eventsRepository = eventsRepository;
    }

    @Override
    public List<DomainEvent> apply(AddShippingOrderToSale command) {
        List<DomainEvent> events = eventsRepository.findByAggregateRootId(command.getSaleId());
        var sale = Sale.from(SaleId.of(command.getSaleId()), events);

        sale.addShippingOrder(
                ShippingOrderId.of(command.getShippingOrderId()),
                new Date(command.getDate()),
                new Price(command.getPrice()),
                new ShippingTime(command.getShippingTime()),
                new State(command.getState())
        );

        return sale.getUncommittedChanges().stream().map(eventsRepository::saveEvent).toList();
    }
}
