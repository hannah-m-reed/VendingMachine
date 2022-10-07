package com.techelevator;

import java.math.BigDecimal;

public class Chip extends Item{
    String phrase = "Crunch Crunch, Yum!";
    public Chip(String name, BigDecimal price) {
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
        return "Chip{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}
