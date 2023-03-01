package co.com.sofkau.domain.ArBikeM;

import co.com.sofkau.domain.ArBikeM.events.BikeAdded;
import co.com.sofkau.domain.ArBikeM.events.BikeCreated;
import co.com.sofkau.domain.ArBikeM.events.BikeManagementCreated;
import co.com.sofkau.domain.ArBikeM.events.SparePartAdded;
import co.com.sofkau.generic.EventChange;

public class BikeManagementEventChange extends EventChange {
    public BikeManagementEventChange(BikesManagement bikesManagement){
        apply((BikeManagementCreated event) -> {
            bikesManagement.creationDate = event.getCreationDate();
        });
        apply((BikeAdded event) -> {
            bikesManagement.bike = event.getBike();
        });
        apply((SparePartAdded event) -> {
            bikesManagement.sparePart = event.getSparePart();
        });
    }
}
