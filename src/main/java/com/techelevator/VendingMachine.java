package com.techelevator;

import java.math.BigDecimal;
import java.util.List;

public class VendingMachine {
    private ChangeSorter changeSorter;
    private Item item;

    public VendingMachine() {
        this.changeSorter = new ChangeSorter();
        this.item = new Item();
    }
}
