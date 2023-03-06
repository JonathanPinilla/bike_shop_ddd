package co.com.sofkau.business.bike;

import co.com.sofkau.business.commons.EventsRepository;
import co.com.sofkau.domain.ArBikeM.commands.CreateBikeManagerCommand;
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
class CreateBikeManagerUseCaseTest {

    @Mock
    private EventsRepository eventsRepository;
    private CreateBikeManagerUseCase createBikeManagerUseCase;

    @BeforeEach
    void setup() {
        createBikeManagerUseCase = new CreateBikeManagerUseCase(eventsRepository);
    }

    @Test
    void successfulScenario() {
        CreateBikeManagerCommand command = new CreateBikeManagerCommand("bikeManagerId", LocalDate.of(2023, 3, 5));

        BikeManagementCreated bikeManagementCreated = new BikeManagementCreated(
                new Date(LocalDate.of(2023, 3, 5))
        );

        bikeManagementCreated.setAggregateRootId("bikeManagerId");

        Mockito.when(eventsRepository.saveEvent(ArgumentMatchers.any())).
                thenAnswer(invocationOnMock -> invocationOnMock.getArgument(0));

        List<DomainEvent> domainEventList = createBikeManagerUseCase.apply(command);
        BikeManagementCreated event = (BikeManagementCreated) domainEventList.get(0);

        Assertions.assertEquals(1, domainEventList.size());
        Assertions.assertEquals("bikeManagerId", event.aggregateRootId());
        Assertions.assertEquals(LocalDate.of(2023, 3, 5), event.getCreationDate().value());
    }

}