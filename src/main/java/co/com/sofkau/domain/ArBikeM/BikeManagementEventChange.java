package co.com.sofkau.domain.ArBikeM;

import co.com.sofkau.domain.ArBikeM.events.BikeAdded;
import co.com.sofkau.domain.ArBikeM.events.BikeCreated;
import co.com.sofkau.domain.ArBikeM.events.BikeManagementCreated;
import co.com.sofkau.domain.ArBikeM.events.SparePartAdded;
import co.com.sofkau.domain.ArBikeM.values.Brand;
import co.com.sofkau.domain.ArBikeM.values.Reference;
import co.com.sofkau.domain.ArBikeM.values.Sold;
import co.com.sofkau.domain.ArBikeM.values.Usage;
import co.com.sofkau.domain.common.*;
import co.com.sofkau.generic.EventChange;

public class BikeManagementEventChange extends EventChange {
    public BikeManagementEventChange(BikesManagement bikesManagement) {
        apply((BikeManagementCreated event) -> {
            bikesManagement.creationDate = event.getCreationDate();
        });
        apply((BikeAdded event) -> {
            Bike bike = new Bike(
                    BikeId.of(event.getBikeId()),
                    new Brand(event.getBrand()),
                    new Type(event.getType()),
                    new Usage(event.getUsage()),
                    new Price(event.getPrice()),
                    new Sold(event.getSold())
            );
            bikesManagement.bikesList.add(bike);
        });
        apply((SparePartAdded event) -> {
            SparePart sparePart = new SparePart(
                    SparePartId.of(event.getSparePartId()),
                    new Name(event.getName()),
                    new Reference(event.getReference()),
                    new Usage(event.getUsage()),
                    new Price(event.getPrice())
            );
            bikesManagement.sparePartsList.add(sparePart);
        });
    }
}
