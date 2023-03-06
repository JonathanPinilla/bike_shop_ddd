package co.com.sofkau.business.bike;

import co.com.sofkau.business.commons.EventsRepository;
import co.com.sofkau.domain.ArBikeM.commands.AddBikeToManager;
import co.com.sofkau.domain.ArBikeM.commands.AddSparePartToManager;
import co.com.sofkau.domain.ArBikeM.events.BikeManagementCreated;
import co.com.sofkau.domain.ArBikeM.events.SparePartAdded;
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
class AddSparePartUseCaseTest {

    @Mock
    private EventsRepository eventsRepository;
    private AddSparePartUseCase addSparePartUseCase;

    @BeforeEach
    void setup() {
        addSparePartUseCase = new AddSparePartUseCase(eventsRepository);
    }

    @Test
    void successfulScenario() {

        BikeManagementCreated bikeManagementCreated = new BikeManagementCreated(
                new Date(LocalDate.of(2023, 3, 5))
        );

        bikeManagementCreated.setAggregateRootId("bikeManagerId");

        AddSparePartToManager command = new AddSparePartToManager(
                "bikeManagerId",
                "sparePartId",
                "name",
                "reference",
                "usage",
                9500.0
        );

        SparePartAdded sparePartAdded = new SparePartAdded(
                "sparePartId",
                "name",
                "reference",
                "usage",
                9500.0
        );

        Mockito.when(eventsRepository.findByAggregateRootId("bikeManagerId")).thenAnswer(
                invocationOnMock -> {
                    return List.of(bikeManagementCreated);
                }
        );

        Mockito.when(eventsRepository.saveEvent(ArgumentMatchers.any())).thenAnswer(invocation -> {
            return invocation.getArgument(0);
        });

        List<DomainEvent> domainEventList = addSparePartUseCase.apply(command);
        SparePartAdded event = (SparePartAdded) domainEventList.get(0);

        Assertions.assertEquals("sparePartId", event.getSparePartId());
        Assertions.assertEquals("name", event.getName());
        Assertions.assertEquals("reference", event.getReference());
        Assertions.assertEquals(1 , domainEventList.size());

    }

}