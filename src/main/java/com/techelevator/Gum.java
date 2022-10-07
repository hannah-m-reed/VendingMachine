package com.techelevator;

import java.math.BigDecimal;

public class Gum extends Item{
    String phrase = "Chew Chew, Yum!";
    public Gum(String name, BigDecimal price) {
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
        return "Gum{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}
