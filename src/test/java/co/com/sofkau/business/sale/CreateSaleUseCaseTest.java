package co.com.sofkau.business.sale;

import co.com.sofkau.business.commons.EventsRepository;
import co.com.sofkau.domain.ArSale.commands.CreateSaleCommand;
import co.com.sofkau.domain.ArSale.events.SaleCreated;
import co.com.sofkau.generic.DomainEvent;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CreateSaleUseCaseTest {

    @Mock
    private EventsRepository eventsRepository;
    private CreateSaleUseCase createSaleUseCase;

    @BeforeEach
    void setup() {
        createSaleUseCase = new CreateSaleUseCase(eventsRepository);
    }

    @Test
    void successfulScenario() {

        CreateSaleCommand command = new CreateSaleCommand("saleId", "clientId", "sellerId");

        SaleCreated saleCreated = new SaleCreated("clientId", "sellerId");
        saleCreated.setAggregateRootId("saleId");

        Mockito.when(eventsRepository.saveEvent(ArgumentMatchers.any())).
                thenAnswer(invocationOnMock -> invocationOnMock.getArgument(0));

        List<DomainEvent> domainEventList = createSaleUseCase.apply(command);
        SaleCreated event = (SaleCreated) domainEventList.get(0);

        Assertions.assertEquals(1, domainEventList.size());
        Assertions.assertEquals("saleId", event.aggregateRootId());
        Assertions.assertEquals("clientId", event.getClient());
    }
}