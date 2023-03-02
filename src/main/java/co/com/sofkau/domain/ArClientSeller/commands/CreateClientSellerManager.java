package co.com.sofkau.domain.ArClientSeller.commands;

import co.com.sofkau.generic.Command;

import java.time.LocalDate;

public class CreateClientSellerManager extends Command {

    private String clientSellerId;
    private LocalDate creationDate;

    public CreateClientSellerManager(String clientSellerId, LocalDate creationDate) {
        this.clientSellerId = clientSellerId;
        this.creationDate = creationDate;
    }

    public String getClientSellerId() {
        return clientSellerId;
    }

    public void setClientSellerId(String clientSellerId) {
        this.clientSellerId = clientSellerId;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }
}
