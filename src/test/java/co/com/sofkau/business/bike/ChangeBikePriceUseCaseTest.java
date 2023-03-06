package co.com.sofkau.business.bike;

import co.com.sofkau.business.commons.EventsRepository;
import co.com.sofkau.domain.ArBikeM.commands.ChangeBikePriceCommand;
import co.com.sofkau.domain.ArBikeM.events.BikeCreated;
import co.com.sofkau.domain.ArBikeM.events.BikeManagementCreated;
import co.com.sofkau.domain.ArBikeM.events.BikePriceChanged;
import co.com.sofkau.domain.common.Date;
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
class ChangeBikePriceUseCaseTest {

    @Mock
    private EventsRepository eventsRepository;
    private ChangeBikePriceUseCase changeBikePriceUseCase;

    @BeforeEach
    void setup() {
        changeBikePriceUseCase = new ChangeBikePriceUseCase(eventsRepository);
    }

    @Test
    void successfulScenario() {

        BikeManagementCreated bikeManagementCreated = new BikeManagementCreated(
                new Date(LocalDate.of(2023, 3, 3))
        );

        bikeManagementCreated.setAggregateRootId("bikeManagerId");

        BikeCreated bikeCreated = new BikeCreated(
                "bikeId",
                "name",
                "reference",
                "usage",
                5000.0,
                false
        );

        bikeCreated.setAggregateRootId("bikeManagerId");

        ChangeBikePriceCommand command = new ChangeBikePriceCommand(
                "bikeManagerId",
                "bikeId",
                10000.0
        );

        BikePriceChanged bikePriceChanged = new BikePriceChanged(
                "bikeId",
                10000.0
        );

        Mockito.when(eventsRepository.findByAggregateRootId("bikeManagerId")).thenAnswer(invocation -> List.of(bikeManagementCreated, bikeCreated));
        Mockito.when(eventsRepository.saveEvent(ArgumentMatchers.any())).thenAnswer(invocation -> invocation.getArgument(0));

        List<DomainEvent> domainEventList = changeBikePriceUseCase.apply(command);
        BikePriceChanged event = (BikePriceChanged) domainEventList.get(0);

        Assertions.assertEquals(10000.0, event.price());
        Assertions.assertEquals("bikeId", event.bikeId());
        Assertions.assertEquals(1, domainEventList.size());
    }
}