package co.com.sofkau.domain.ArBikeM;

import co.com.sofkau.domain.common.Price;
import co.com.sofkau.domain.ArBikeM.values.Reference;
import co.com.sofkau.domain.ArBikeM.values.Usage;
import co.com.sofkau.domain.common.Id;
import co.com.sofkau.domain.common.Name;
import co.com.sofkau.generic.Entity;

public class SparePart extends Entity<Id>{

    protected Name name;
    protected Reference reference;
    protected Usage usage;
    protected Price price;

    public SparePart(Id id, Name name, Reference reference, Usage usage, Price price) {
        super(id);
        this.name = name;
        this.reference = reference;
        this.usage = usage;
        this.price = price;
    }

    public void changePartName(String reason, Name name){
        if (!reason.equals("")) {
            throw new IllegalArgumentException("Reason should be added to change the name of a Spare part");
        }
        this.name = name;
    }

    public void changePartPrice(String reason, Price price) {
        if (!reason.equals("IPC")) {
            throw new IllegalArgumentException("The reason should be IPC or else you can't change the price");
        }
        this.price = price;
    }

    public void changePartReference(String reason, Reference reference){
        if (!reason.equals("")) {
            throw new IllegalArgumentException("Reason should be added to change the reference of a Spare part");
        }
        this.reference = reference;
    }

    public Usage usage(){
        return usage;
    }

    public Name name(){
        return name;
    }

    public Reference reference(){
        return reference;
    }

    public Price price(){
        return price;
    }
}
