package co.com.sofkau.domain.bikesMAR.commands;

import co.com.sofkau.generic.Command;

public class AddSparePartToManager extends Command {

    private final String bikeManagerId;
    private final String sparePartID;

    public AddSparePartToManager(String bikeManagerId, String sparePartID) {
        this.bikeManagerId = bikeManagerId;
        this.sparePartID = sparePartID;
    }

    public String getBikeManagerId() {
        return bikeManagerId;
    }

    public String getSparePartID() {
        return sparePartID;
    }

}
