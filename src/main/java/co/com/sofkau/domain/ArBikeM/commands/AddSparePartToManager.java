package co.com.sofkau.domain.ArBikeM.commands;

import co.com.sofkau.domain.ArBikeM.SparePart;
import co.com.sofkau.domain.common.Id;
import co.com.sofkau.generic.Command;

public class AddSparePartToManager extends Command {

    private final Id bikeManagerId;
    private final SparePart sparePart;

    public AddSparePartToManager(Id bikeManagerId, SparePart sparePart) {
        this.bikeManagerId = bikeManagerId;
        this.sparePart = sparePart;
    }

    public Id getBikeManagerId() {
        return bikeManagerId;
    }

    public SparePart getSparePart() {
        return sparePart;
    }

}
