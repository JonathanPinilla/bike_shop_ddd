package co.com.sofkau.domain.ArClientSeller.commands;

import co.com.sofkau.generic.Command;

public class CreateSeller extends Command {

    private String sellerId;
    private String name;
    private String lname;
    private String charge;

    public CreateSeller(String sellerId, String name, String lname, String charge) {
        this.sellerId = sellerId;
        this.name = name;
        this.lname = lname;
        this.charge = charge;
    }

    public String getSellerId() {
        return sellerId;
    }

    public void setSellerId(String sellerId) {
        this.sellerId = sellerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getCharge() {
        return charge;
    }

    public void setCharge(String charge) {
        this.charge = charge;
    }
}
