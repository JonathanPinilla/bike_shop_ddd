package co.com.sofkau.business.clientSeller;

import co.com.sofkau.business.commons.EventsRepository;
import co.com.sofkau.domain.ArClientSeller.commands.AddSellerToManager;
import co.com.sofkau.domain.ArClientSeller.events.ClientSellerCreated;
import co.com.sofkau.domain.ArClientSeller.events.SellerAdded;
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
class AddSellerUseCaseTest {

    @Mock
    private EventsRepository eventsRepository;
    private AddSellerUseCase addSellerUseCase;

    @BeforeEach
    void setup() {
        addSellerUseCase = new AddSellerUseCase(eventsRepository);
    }

    @Test
    void successfulScenario() {
        //arrange
        ClientSellerCreated clientSellerCreated = new ClientSellerCreated(LocalDate.of(2022, 5, 19));
        clientSellerCreated.setAggregateRootId("clientSellerId");

        AddSellerToManager command = new AddSellerToManager(
                "clientSellerId",
                "sellerId",
                "Juan",
                "Perez",
                "New bikes seller"
        );

        SellerAdded sellerAdded = new SellerAdded(
                "sellerId",
                "Juan",
                "Perez",
                "New bikes seller"
        );
        sellerAdded.setAggregateRootId("clientSellerId");

        Mockito.when(eventsRepository.findByAggregateRootId("clientSellerId")).thenReturn(List.of(clientSellerCreated));
        Mockito.when(eventsRepository.saveEvent(ArgumentMatchers.any())).thenAnswer(invocation -> invocation.getArgument(0));
        //act
        List<DomainEvent> domainEventList = addSellerUseCase.apply(command);
        //assert
        Assertions.assertEquals(1, domainEventList.size());
        SellerAdded event = (SellerAdded) domainEventList.get(0);
        Assertions.assertEquals("sellerId", event.getSellerId());
        Assertions.assertEquals("Juan", event.getName());
        Assertions.assertEquals("Perez", event.getLname());
        Assertions.assertEquals("New bikes seller", event.getCharge());

    }

}