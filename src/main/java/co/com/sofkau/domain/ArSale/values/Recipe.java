package co.com.sofkau.domain.ArSale.values;

import co.com.sofkau.domain.common.Id;
import co.com.sofkau.domain.common.Price;
import co.com.sofkau.generic.ValueObject;

import java.time.LocalDate;

public class Recipe implements ValueObject<Recipe.Props> {

    private Bikes bikes;
    private Price price;
    private LocalDate localDate;
    private Client client;
    private Seller seller;

    public Recipe(Bikes bikes, Price price, LocalDate localDate, Client client, Seller seller) {
        this.bikes = bikes;
        this.price = price;
        this.localDate = localDate;
        this.client = client;
        this.seller = seller;
    }

    @Override
    public Props value() {
        return new Props() {
            @Override
            public Bikes bikes() {
                return bikes;
            }

            @Override
            public Client client() {
                return client;
            }

            @Override
            public Seller seller() {
                return seller;
            }

            @Override
            public Price price() {
                return price;
            }

            @Override
            public LocalDate localDate() {
                return localDate;
            }
        };
    }

    public void addBike(Id bikeId) {
        this.bikes.add(bikeId);
    }

    interface Props {
        Bikes bikes();

        Client client();

        Seller seller();

        Price price();

        LocalDate localDate();
    }
}
