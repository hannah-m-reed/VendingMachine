package com.techelevator;

import java.math.BigDecimal;
import java.util.List;

public class VendingMachine {
    private ChangeSorter changeSorter;

    public VendingMachine() {
        this.changeSorter = new ChangeSorter();
        VendingInventory.inventorySetup();
    }
}
