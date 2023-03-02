package co.com.sofkau.domain.ArBikeM;

import co.com.sofkau.domain.ArBikeM.events.*;
import co.com.sofkau.domain.ArSale.values.Bikes;
import co.com.sofkau.domain.common.*;
import co.com.sofkau.generic.AggregateRoot;
import co.com.sofkau.generic.DomainEvent;

import java.util.List;

public class BikesManagement extends AggregateRoot<BikesManagementId> {

    protected List<Bikes> bikesList;
    protected List<SparePart> sparePartsList;
    protected Date creationDate;

    public BikesManagement(BikesManagementId bikesManagementId, Date creationDate) {
        super(bikesManagementId);
        subscribe(new BikeManagementEventChange(this));
        appendChange(new BikeManagementCreated(creationDate)).apply();
    }

    public BikesManagement(BikesManagementId bikesManagementId) {
        super(bikesManagementId);
        subscribe(new BikeManagementEventChange(this));
    }

    public static BikesManagement from(BikesManagementId bikeManagementId, List<DomainEvent> events) {
        var bikeManagement = new BikesManagement(bikeManagementId);
        events.forEach(bikeManagement::applyEvent);
        return bikeManagement;
    }

    public void createBike(String bikeId, String brand, String type, String usage, Double price, Boolean sold) {
        appendChange(new BikeCreated(bikeId, brand, type, usage, price, sold)).apply();
    }

    public void createSparePart(String sparePartId, String name, String reference, String usage, Double price) {
        appendChange(new SparePartCreated(sparePartId, name, reference, usage, price)).apply();
    }

    public void addBike(String bikeId, String brand, String type, String usage, Double price, Boolean sold) {
        appendChange(new BikeAdded(bikeId, brand, type, usage, price, sold)).apply();
    }

    public void addSparePart(String sparePartId, String name, String reference, String usage, Double price) {
        appendChange(new SparePartAdded(sparePartId, name, reference, usage, price)).apply();
    }
}
