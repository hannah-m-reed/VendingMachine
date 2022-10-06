package com.techelevator;

public class Gum extends Item{
    String phrase = "Chew Chew, Yum!";
    public Gum(String name, double price) {
        super(name, price);
    }

    public String getPhrase() {
        return phrase;
    }
}
