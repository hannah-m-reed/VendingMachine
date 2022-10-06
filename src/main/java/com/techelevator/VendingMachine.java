package com.techelevator;

import java.math.BigDecimal;
import java.util.List;

public class VendingMachine {
    private VendingInventory vendingInventory;
    private ChangeSorter changeSorter;

    public VendingMachine() {
        this.vendingInventory = new VendingInventory();
        this.changeSorter = new ChangeSorter();
    }
    public String[][] getInventory(){
        return this.vendingInventory.getInventory();
    }
}
