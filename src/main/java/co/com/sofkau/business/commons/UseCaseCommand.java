package co.com.sofkau.business.commons;

import co.com.sofkau.generic.Command;
import co.com.sofkau.generic.DomainEvent;

import java.util.List;

public interface UseCaseCommand <T extends Command>{

    List<DomainEvent> apply(T command);

}
