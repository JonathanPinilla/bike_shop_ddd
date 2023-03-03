package co.com.sofkau.business.sale;

import co.com.sofkau.business.commons.EventsRepository;
import co.com.sofkau.business.commons.UseCaseCommand;
import co.com.sofkau.domain.ArSale.Sale;
import co.com.sofkau.domain.ArSale.commands.AddPaymentToSale;
import co.com.sofkau.domain.ArSale.values.Bank;
import co.com.sofkau.domain.common.PaymentId;
import co.com.sofkau.domain.common.SaleId;
import co.com.sofkau.domain.common.Type;
import co.com.sofkau.generic.DomainEvent;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AddPaymentUseCase implements UseCaseCommand<AddPaymentToSale> {

    EventsRepository eventsRepository;

    public AddPaymentUseCase(EventsRepository eventsRepository) {
        this.eventsRepository = eventsRepository;
    }

    @Override
    public List<DomainEvent> apply(AddPaymentToSale command) {
        List<DomainEvent> events = eventsRepository.findByAggregateRootId(command.getSaleId());
        var sale = Sale.from(SaleId.of(command.getSaleId()), events);

        sale.addPayment(
                PaymentId.of(command.getPaymentId()),
                new Type(command.getType()),
                new Bank(command.getBank()),
                command.getRecipe()
        );

        return sale.getUncommittedChanges().stream().map(eventsRepository::saveEvent).toList();
    }
}
