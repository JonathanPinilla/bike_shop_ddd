package co.com.sofkau.domain.ArClientSeller.values;

import co.com.sofkau.domain.common.Name;
import co.com.sofkau.generic.ValueObject;

public class CreditCard implements ValueObject<CreditCard.Params> {

    private Name name;
    private Lname lname;
    private Integer cardNumber;
    private Integer expireYear;
    private Integer expireMonth;
    private Integer cvv;

    public CreditCard(Name name, Lname lname, Integer cardNumber, Integer expireYear, Integer expireMonth, Integer cvv) {
        this.name = name;
        this.lname = lname;
        this.cardNumber = cardNumber;
        this.expireYear = expireYear;
        this.expireMonth = expireMonth;
        this.cvv = cvv;
    }

    public CreditCard() {

    }

    @Override
    public Params value() {
        return new Params() {
            @Override
            public Name name() {
                return name;
            }

            @Override
            public Lname lname() {
                return lname;
            }

            @Override
            public Integer cardNumber() {
                return cardNumber;
            }

            @Override
            public Integer expireYear() {
                return expireYear;
            }

            @Override
            public Integer expireMonth() {
                return expireMonth;
            }

            @Override
            public Integer cvv() {
                return cvv;
            }
        };
    }

    interface Params {
        Name name();

        Lname lname();

        Integer cardNumber();

        Integer expireYear();

        Integer expireMonth();

        Integer cvv();
    }
}
