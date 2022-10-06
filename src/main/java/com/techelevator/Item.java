package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

import static java.lang.Integer.parseInt;

public abstract class Item{
    String name;
    double price;
    int quantity;

    public Item(String name, double price){
        this.name = name;
        this.price = price;
        this.quantity = 5;
    }



    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
    public int getQuantity() {
        return quantity;
    }
}
