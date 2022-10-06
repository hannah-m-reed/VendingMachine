package com.techelevator;

public class Chip extends Item{
    String phrase = "Crunch Crunch, Yum!";
    public Chip(String name, double price) {
        super(name, price);
    }

    public String getPhrase() {
        return phrase;
    }
}
