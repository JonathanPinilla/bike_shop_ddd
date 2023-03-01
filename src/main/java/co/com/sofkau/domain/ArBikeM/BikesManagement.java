package co.com.sofkau.domain.ArBikeM;

import co.com.sofkau.domain.ArBikeM.events.*;
import co.com.sofkau.domain.ArBikeM.values.Brand;
import co.com.sofkau.domain.ArBikeM.values.Reference;
import co.com.sofkau.domain.ArBikeM.values.Usage;
import co.com.sofkau.domain.common.*;
import co.com.sofkau.generic.AggregateRoot;
import co.com.sofkau.generic.DomainEvent;

import java.util.List;

public class BikesManagement extends AggregateRoot<Id> {

    protected Bike bike;
    protected SparePart sparePart;
    protected List<SparePart> sparePartsList;
    protected Date creationDate;

    public BikesManagement(Id id, Date creationDate) {
        super(id);
        subscribe(new BikeManagementEventChange(this));
        appendChange(new BikeManagementCreated(creationDate)).apply();
    }

    public BikesManagement(Id id) {
        super(id);
        subscribe(new BikeManagementEventChange(this));
    }

    public static BikesManagement from(Id bikeManagementId, List<DomainEvent> events) {
        var bikeManagement = new BikesManagement(bikeManagementId);
        events.forEach(bikeManagement::applyEvent);
        return bikeManagement;
    }

    public void createBike(Id bikeId, Brand brand, Type type, Usage usage, Price price) {
        appendChange(new BikeCreated(bikeId, brand, type, usage, price)).apply();
    }

    public void createSparePart(Id sparePartId, Name name, Reference reference, Usage usage, Price price){
        appendChange(new SparePartCreated(sparePartId, name, reference, usage, price)).apply();
    }

    public void addBike(Bike bike){
        appendChange(new BikeAdded(bike)).apply();
    }

    public void addSparePart(SparePart sparePart){
        appendChange(new SparePartAdded(sparePart)).apply();
    }

    public Price getBikePrice() {
        return this.bike.price();
    }

    public Date getCreationDate() {
        return creationDate;
    }
}
