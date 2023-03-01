package co.com.sofkau.domain.ArSale.commands;

import co.com.sofkau.generic.Command;

import java.time.LocalDate;

public class CreateShippingOrderCommand extends Command {

    private String shippingOrderId;
    private String price;
    private LocalDate localDate;
    private String shippingTime;
    private String state;
}
