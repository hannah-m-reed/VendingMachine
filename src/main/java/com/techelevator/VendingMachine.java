package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class VendingMachine {
    MoneyBox moneyBox;
    VendingInventory vendingInventory;

    public VendingMachine() {
        this.moneyBox = new MoneyBox();
        this.vendingInventory = new VendingInventory();
    }
    public void createLogFile(){
        File log = new File("log.txt");
        try(PrintWriter output = new PrintWriter(log)){
            output.println();
        }catch(FileNotFoundException e){
            System.out.println("Log file not found");
        }
    }
}
