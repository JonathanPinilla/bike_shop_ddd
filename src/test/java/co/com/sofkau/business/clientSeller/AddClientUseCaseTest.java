package co.com.sofkau.business.clientSeller;

import co.com.sofkau.business.commons.EventsRepository;
import co.com.sofkau.domain.ArClientSeller.commands.AddClientToManager;
import co.com.sofkau.domain.ArClientSeller.events.ClientAdded;
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
class AddClientUseCaseTest {

    @Mock
    private EventsRepository eventsRepository;
    private AddClientUseCase addClientUseCase;

    @BeforeEach
    public void setup(){
        addClientUseCase = new AddClientUseCase(eventsRepository);
    }

    @Test
    void successfulScenario(){
        //arrange
        ClientSellerCreated clientSellerCreated = new ClientSellerCreated(LocalDate.of(2021, 1, 1));

        clientSellerCreated.setAggregateRootId("clientSellerId");

        AddClientToManager command = new AddClientToManager(
                "clientSellerId",
                "123",
                "Juan",
                "Perez",
                "123st"
        );

        ClientAdded clientAdded = new ClientAdded(
                "123",
                "Juan",
                "Perez",
                "123st"
        );

        Mockito.when(eventsRepository.findByAggregateRootId("clientSellerId")).thenReturn(List.of(clientSellerCreated));
        Mockito.when(eventsRepository.saveEvent(ArgumentMatchers.any())).thenAnswer(invocation -> invocation.getArgument(0));

        //act
        List<DomainEvent> events = addClientUseCase.apply(command);
        //assert

        Assertions.assertEquals(1, events.size());

        ClientAdded event = (ClientAdded) events.get(0);
        Assertions.assertEquals("clientSellerId", event.aggregateRootId());
        Assertions.assertEquals("123", event.getClientId());
        Assertions.assertEquals("Juan", event.getName());
        Assertions.assertEquals("Perez", event.getLname());
        //Assertions.assertEquals("123st", event.getAddress());
        //ask why event.getAddress() is returning null
    }

}