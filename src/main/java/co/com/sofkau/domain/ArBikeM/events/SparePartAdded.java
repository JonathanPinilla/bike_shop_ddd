package co.com.sofkau.domain.ArBikeM.events;

import co.com.sofkau.domain.ArBikeM.SparePart;
import co.com.sofkau.generic.DomainEvent;

public class SparePartAdded extends DomainEvent {

    private final SparePart sparePart;

    public SparePartAdded(SparePart sparePart) {
        super("co.com.sofkau.ArBikeM.SparePart.added");
        this.sparePart = sparePart;
    }

    public SparePart getSparePart() {
        return sparePart;
    }
}
