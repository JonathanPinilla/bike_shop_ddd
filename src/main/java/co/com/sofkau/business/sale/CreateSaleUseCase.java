package co.com.sofkau.business.sale;

import co.com.sofkau.business.commons.EventsRepository;
import co.com.sofkau.business.commons.UseCaseCommand;
import co.com.sofkau.domain.ArSale.Sale;
import co.com.sofkau.domain.ArSale.commands.CreateSaleCommand;
import co.com.sofkau.domain.common.ClientId;
import co.com.sofkau.domain.common.SaleId;
import co.com.sofkau.domain.common.SellerId;
import co.com.sofkau.generic.DomainEvent;

import java.util.List;

public class CreateSaleUseCase implements UseCaseCommand<CreateSaleCommand> {

    EventsRepository eventsRepository;

    public CreateSaleUseCase(EventsRepository eventsRepository) {
        this.eventsRepository = eventsRepository;
    }

    @Override
    public List<DomainEvent> apply(CreateSaleCommand command) {
        var sale = new Sale(SaleId.of(command.getSaleId()), ClientId.of(command.getClient()), SellerId.of(command.getSeller()));
        return sale.getUncommittedChanges().stream().map(eventsRepository::saveEvent).toList();
    }
}
