package co.com.sofkau.domain.bikesMAR.values;

import co.com.sofkau.generic.ValueObject;

public class Parts implements ValueObject<Parts.Props> {

    private int availableNumber;
    private String reference;

    public Parts(int availableNumber, String reference) {
        this.availableNumber = availableNumber;
        this.reference = reference;
    }

    @Override
    public Props value() {
        return new Props() {
            @Override
            public int availableNumber() {
                return availableNumber;
            }

            @Override
            public String reference() {
                return reference;
            }
        };
    }

    interface Props {
        int availableNumber();

        String reference();
    }
}
