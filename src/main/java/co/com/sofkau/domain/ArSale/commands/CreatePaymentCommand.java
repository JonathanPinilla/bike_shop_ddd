package co.com.sofkau.domain.ArSale.commands;

import co.com.sofkau.generic.Command;

public class CreatePaymentCommand extends Command {

    private String paymentId;
    private String type;
    private String bank;

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }
}
