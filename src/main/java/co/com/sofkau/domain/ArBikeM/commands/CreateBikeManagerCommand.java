package co.com.sofkau.domain.ArBikeM.commands;

import co.com.sofkau.generic.Command;

import java.time.LocalDate;

public class CreateBikeManagerCommand extends Command {

    private String bikeManagerId;
    private LocalDate creationDate;


    public CreateBikeManagerCommand(String bikeManagerId, LocalDate creationDate) {
        this.bikeManagerId = bikeManagerId;
        this.creationDate = creationDate;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public String getBikeManagerId() {
        return bikeManagerId;
    }

    public void setBikeManagerId(String bikeManagerId) {
        this.bikeManagerId = bikeManagerId;
    }
}
