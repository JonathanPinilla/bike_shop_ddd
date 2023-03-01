package co.com.sofkau.domain.ArSale.values;

import co.com.sofkau.generic.ValueObject;

import java.time.LocalDate;

public class Date implements ValueObject<LocalDate> {
    private LocalDate date;

    public Date(LocalDate date) {
        this.date = date;
    }

    @Override
    public LocalDate value() {
        return date;
    }
}
