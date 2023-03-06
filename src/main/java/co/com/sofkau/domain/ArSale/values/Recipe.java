package co.com.sofkau.domain.ArSale.values;

import co.com.sofkau.domain.common.BikeId;
import co.com.sofkau.domain.common.ClientId;
import co.com.sofkau.domain.common.Price;
import co.com.sofkau.domain.common.SellerId;
import co.com.sofkau.generic.ValueObject;

import java.time.LocalDate;

public class Recipe implements ValueObject<Recipe.Props> {

    private Bikes bikes;
    private Price price;
    private LocalDate localDate;
    private ClientId client;
    private SellerId seller;

    public Recipe(Bikes bikes, Price price, LocalDate localDate, ClientId client, SellerId seller) {
        this.bikes = bikes;
        this.price = price;
        this.localDate = localDate;
        this.client = client;
        this.seller = seller;
    }

    public Recipe() {

    }

    @Override
    public Props value() {
        return new Props() {
            @Override
            public Bikes bikes() {
                return bikes;
            }

            @Override
            public ClientId client() {
                return client;
            }

            @Override
            public SellerId seller() {
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

    public void addBike(BikeId bikeId) {
        this.bikes.add(bikeId);
    }

    interface Props {
        Bikes bikes();

        ClientId client();

        SellerId seller();

        Price price();

        LocalDate localDate();
    }
}
