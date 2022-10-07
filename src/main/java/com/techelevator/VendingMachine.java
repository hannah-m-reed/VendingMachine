package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class VendingMachine {
    MoneyBox moneyBox;
    VendingInventory vendingInventory;

    public VendingMachine() {
        this.moneyBox = new MoneyBox();
        this.vendingInventory = new VendingInventory();
    }
}
