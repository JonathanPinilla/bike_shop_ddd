package co.com.sofkau.business.sale;

import co.com.sofkau.business.commons.EventsRepository;
import co.com.sofkau.domain.ArSale.commands.AddPaymentToSale;
import co.com.sofkau.domain.ArSale.events.PaymentAdded;
import co.com.sofkau.domain.ArSale.events.SaleCreated;
import co.com.sofkau.domain.ArSale.values.Recipe;
import co.com.sofkau.generic.DomainEvent;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class AddPaymentUseCaseTest {

    @Mock
    private EventsRepository eventsRepository;
    private AddPaymentUseCase addPaymentUseCase;

    @BeforeEach
    public void setup(){
        addPaymentUseCase = new AddPaymentUseCase(eventsRepository);
    }

    @Test
    void successfulScenario(){

        SaleCreated saleCreated = new SaleCreated("clientId", "sellerId");
        saleCreated.setAggregateRootId("saleId");

        AddPaymentToSale addPaymentToSale = new AddPaymentToSale("saleId", "paymentId", "paymentMethod", "Bancolombia",new Recipe());
        PaymentAdded paymentAdded = new PaymentAdded("paymentId", "paymentMethod", "Bancolombia", new Recipe());

        Mockito.when(eventsRepository.findByAggregateRootId("saleId")).thenReturn(List.of(saleCreated));
        Mockito.when(eventsRepository.saveEvent(ArgumentMatchers.any())).thenAnswer(invocation -> invocation.getArgument(0));

        List<DomainEvent> domainEventList = addPaymentUseCase.apply(addPaymentToSale);
        PaymentAdded event = (PaymentAdded) domainEventList.get(0);

        Assertions.assertEquals("paymentId", event.getPaymentId());
        Assertions.assertEquals("paymentMethod", event.getType());
        //Assertions.assertEquals("Bancolombia", event.getBank());

    }

}