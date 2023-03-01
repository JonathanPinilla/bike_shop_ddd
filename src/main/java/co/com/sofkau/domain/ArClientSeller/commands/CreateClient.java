package co.com.sofkau.domain.ArClientSeller.commands;

import co.com.sofkau.generic.Command;

public class CreateClient extends Command {

    private final String clientId;
    private final String name;
    private final String lname;
    private final String address;

    public CreateClient(String clientId, String name, String lname, String address) {
        this.clientId = clientId;
        this.name = name;
        this.lname = lname;
        this.address = address;
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
