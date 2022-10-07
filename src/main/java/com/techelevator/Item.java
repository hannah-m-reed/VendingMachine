package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.*;

import static java.lang.Integer.parseInt;

public abstract class Item{
    String name;
    BigDecimal price;
    int quantity;

    String phrase = "";

    public Item(String name, BigDecimal price){
        this.name = name;
        this.price = price;
        this.quantity = 5;
    }



    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }
    public int getQuantity() {
        return quantity;
    }

    public boolean setQuantity(){
        if(this.quantity > 0) {
            this.quantity--;
            return true;
        }else{
            System.out.println("Item sold out");
            return false;
        }
    }
    public String getPhrase() {
        return phrase;
    }
}
