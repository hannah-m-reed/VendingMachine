package com.techelevator;

public class Candy extends Item{
    String phrase = "Munch Munch, Yum!";
    public Candy(String name, double price) {
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
        return "Candy{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}
