package co.com.sofkau.business.bike;

import co.com.sofkau.business.commons.EventsRepository;
import co.com.sofkau.domain.ArBikeM.commands.AddBikeToManager;
import co.com.sofkau.domain.ArBikeM.events.BikeAdded;
import co.com.sofkau.domain.ArBikeM.events.BikeManagementCreated;
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

import java.lang.reflect.InvocationTargetException;
import java.time.LocalDate;
import java.util.List;

@ExtendWith(MockitoExtension.class)
class AddBikeUseCaseTest {

    @Mock
    private EventsRepository eventsRepository;
    private AddBikeUseCase addBikeUseCase;

    @BeforeEach
    void setup() {
        addBikeUseCase = new AddBikeUseCase(eventsRepository);
    }

    @Test
    void successfulScenario() {
        BikeManagementCreated bikeManagementCreated = new BikeManagementCreated(
                new Date(LocalDate.of(2023, 3, 5))
        );

        bikeManagementCreated.setAggregateRootId("bikeManagerId");

        AddBikeToManager command = new AddBikeToManager(
                "bikeManagerId",
                "bikeId",
                "brand",
                "type",
                "usage",
                9000.0,
                false
        );

        BikeAdded bikeAdded = new BikeAdded(
                "bikeId",
                "brand",
                "type",
                "usage",
                9000.0,
                false
        );

        bikeAdded.setAggregateRootId("bikeManagerId");

        Mockito.when(eventsRepository.findByAggregateRootId("bikeManagerId")).thenAnswer(
                invocationOnMock -> {
                    return List.of(bikeManagementCreated);
                }
        );

        Mockito.when(eventsRepository.saveEvent(ArgumentMatchers.any(BikeAdded.class))).
                thenAnswer(invocationOnMock -> {
                    return invocationOnMock.getArgument(0);
                });

        // Act
        List<DomainEvent> domainEventList = addBikeUseCase.apply(command);
        BikeAdded event = (BikeAdded) domainEventList.get(0);

        // Assert
        Assertions.assertEquals("bikeId", event.getBikeId());
        Assertions.assertEquals("bikeManagerId", event.aggregateRootId());
        Assertions.assertEquals("brand", event.getBrand());
    }

}