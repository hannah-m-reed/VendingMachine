package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

public class VendingMachine {
    MoneyBox moneyBox;
    VendingInventory vendingInventory;

    public VendingMachine() {
        this.moneyBox = new MoneyBox();
        this.vendingInventory = new VendingInventory();
    }
    public void createLogFile(String action, BigDecimal delta){
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss aa");
        String stringDate = formatter.format(new Date());

        File log = new File("log.txt");

        try(PrintWriter output = new PrintWriter(new FileOutputStream(log, true))){
            output.printf("%s %s $%.2f $%2.2f\n", stringDate, action, delta, this.moneyBox.getCurrentMoney());
        }catch(FileNotFoundException e){
            System.out.println("Log file not found");
        }
    }
}
