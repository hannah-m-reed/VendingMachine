package com.techelevator;

import java.math.BigDecimal;

public class Drink extends Item{
    String phrase = "Glug Glug, Yum!";
    public Drink(String name, BigDecimal price) {
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
        return "Drink{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}
