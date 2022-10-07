package com.techelevator;

public class Chip extends Item{
    String phrase = "Crunch Crunch, Yum!";
    public Chip(String name, double price) {
        super(name, price);
    }

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
