package co.com.sofkau.domain.ArClientSeller.commands;

import co.com.sofkau.generic.Command;

public class CreateSeller extends Command {

    private final String sellerId;
    private final String name;
    private final String lname;
    private final String charge;

    public CreateSeller(String sellerId, String name, String lname, String charge) {
        this.sellerId = sellerId;
        this.name = name;
        this.lname = lname;
        this.charge = charge;
    }

    public String getSellerId() {
        return sellerId;
    }

    public String getName() {
        return name;
    }

    public String getLname() {
        return lname;
    }

    public String getCharge() {
        return charge;
    }
}
