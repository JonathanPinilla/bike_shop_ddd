package co.com.sofkau.business.clientSeller;

import co.com.sofkau.business.commons.EventsRepository;
import co.com.sofkau.domain.ArClientSeller.commands.ChangeClientAddressCommand;
import co.com.sofkau.domain.ArClientSeller.events.ClientAddressChanged;
import co.com.sofkau.domain.ArClientSeller.events.ClientCreated;
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
class ChangeClientAddressUseCaseTest {

    @Mock
    private EventsRepository eventsRepository;
    private ChangeClientAddressUseCase changeClientAddressUseCase;

    @BeforeEach
    public void setup(){
        changeClientAddressUseCase = new ChangeClientAddressUseCase(eventsRepository);
    }

    @Test
    void successfulScenario(){

        // Arrange
        ClientSellerCreated clientSellerCreated = new ClientSellerCreated(LocalDate.of(2019, 9, 27));
        clientSellerCreated.setAggregateRootId("clientSellerId");

        ClientCreated clientCreated = new ClientCreated(
                "clientId",
                "name",
                "lastName",
                "address"
        );
        clientCreated.setAggregateRootId("clientSellerId");

        ChangeClientAddressCommand command = new ChangeClientAddressCommand(
                "clientSellerId",
                "clientId",
                "new address"
        );

        ClientAddressChanged clientAddressChanged = new ClientAddressChanged(
                "clientId",
                "new address"
        );

        Mockito.when(eventsRepository.findByAggregateRootId("clientSellerId")).thenReturn(List.of(
                clientSellerCreated,
                clientCreated
        ));
        Mockito.when(eventsRepository.saveEvent(ArgumentMatchers.any())).thenAnswer(invocationOnMock -> {
            return invocationOnMock.getArgument(0);
        });
        // Act
        List<DomainEvent> domainEventList = changeClientAddressUseCase.apply(command);
        ClientAddressChanged event = (ClientAddressChanged) domainEventList.get(0);
        // Assert

        Assertions.assertEquals(1, domainEventList.size());
        Assertions.assertEquals("new address", event.getAddress());
        Assertions.assertEquals("clientId", event.getClientId());


    }

}