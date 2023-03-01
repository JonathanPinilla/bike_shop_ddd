package co.com.sofkau.domain.ArBikeM;

import co.com.sofkau.domain.common.Id;
import co.com.sofkau.domain.common.Price;
import co.com.sofkau.generic.AggregateRoot;

import java.util.List;

public class BikesManagement extends AggregateRoot<Id> {

    private Bike bike;
    private SparePart sparePart;
    private List<SparePart> sparePartsList;

    public BikesManagement(Id id) {
        super(id);
    }

    public Price getBikePrice(){
        return this.bike.price();
    }
}
