package com.techelevator;

import java.math.BigDecimal;

public class Candy extends Item{
    String phrase = "Munch Munch, Yum!";
    public Candy(String name, BigDecimal price) {
        super(name, price);
    }

    @Override
    public String getPhrase() {
        return phrase;
    }

    @Override
    public int getQuantity() {
        return super.getQuantity();
    }

    @Override
    public String toString() {
        return "Candy{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}
