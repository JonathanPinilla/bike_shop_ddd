package co.com.sofkau.domain.ArClientSeller.commands;

import co.com.sofkau.generic.Command;

public class AddClientToManager extends Command {

    private final String clientSellerId;
    private final String clientId;
    private final String name;
    private final String lname;
    private final String address;

    public AddClientToManager(String clientSellerId, String clientId, String name, String lname, String address) {
        this.clientSellerId = clientSellerId;
        this.clientId = clientId;
        this.name = name;
        this.lname = lname;
        this.address = address;
    }

    public String getClientSellerId() {
        return clientSellerId;
    }

    public String getClientId() {
        return clientId;
    }

    public String getName() {
        return name;
    }

    public String getLname() {
        return lname;
    }

    public String getAddress() {
        return address;
    }

}
