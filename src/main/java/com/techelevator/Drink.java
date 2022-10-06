package com.techelevator;

public class Drink extends Item{
    String phrase = "Glug Glug, Yum!";
    public Drink(String name, double price) {
        super(name, price);
    }

    public String getPhrase() {
        return phrase;
    }
}
