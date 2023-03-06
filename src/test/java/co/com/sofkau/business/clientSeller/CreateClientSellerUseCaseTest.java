package co.com.sofkau.business.clientSeller;

import co.com.sofkau.business.commons.EventsRepository;
import co.com.sofkau.domain.ArClientSeller.commands.CreateClientSellerManager;
import co.com.sofkau.domain.ArClientSeller.events.ClientSellerCreated;
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
class CreateClientSellerUseCaseTest {

    @Mock
    private EventsRepository eventsRepository;
    private CreateClientSellerUseCase createClientSellerUseCase;

    @BeforeEach
    void setup() {
        createClientSellerUseCase = new CreateClientSellerUseCase(eventsRepository);
    }

    @Test
    void successfulScenario() {
        CreateClientSellerManager command = new CreateClientSellerManager("clientSellerId", LocalDate.of(2022, 12, 10));

        ClientSellerCreated clientSellerCreated = new ClientSellerCreated(LocalDate.of(2022, 12, 10));
        clientSellerCreated.setAggregateRootId("clientSellerId");

        Mockito.when(eventsRepository.saveEvent(ArgumentMatchers.any())).
                thenAnswer(invocationOnMock -> invocationOnMock.getArgument(0));

        List<DomainEvent> domainEventList = createClientSellerUseCase.apply(command);
        ClientSellerCreated event = (ClientSellerCreated) domainEventList.get(0);

        Assertions.assertEquals(1, domainEventList.size());
        Assertions.assertEquals("clientSellerId", event.aggregateRootId());
        Assertions.assertEquals(LocalDate.of(2022, 12, 10), event.getCreationDate());
    }

}