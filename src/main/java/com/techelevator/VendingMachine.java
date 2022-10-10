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

    //VendingMachine constructor creates object instances of MoneyBox and VendingInventory classes
    public VendingMachine() {
        this.moneyBox = new MoneyBox();
        this.vendingInventory = new VendingInventory();
    }
    //Method creates log file formatted with date and time of all transactions
    public void createLogFile(String action, BigDecimal delta){
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss aa");
        String stringDate = formatter.format(new Date());
        File log = new File("log.txt");

        //Try with resources opens file and adds date, action, change in balance, and current balance to log file
        try(PrintWriter output = new PrintWriter(new FileOutputStream(log, true))){
            output.printf("%s %s $%.2f $%2.2f\n", stringDate, action, delta, this.moneyBox.getCurrentMoney());
        }catch(FileNotFoundException e){
            System.out.println("Log file not found");
        }
    }
    //Method generates a dated file with item amount sold and total money collected
    public void generateSalesReceipt(){
        SimpleDateFormat formatter = new SimpleDateFormat("dd_MM_yyyy__hh_mmaa");
        String stringSalesDate = formatter.format(new Date());
        File salesReport = new File("SalesReport" + stringSalesDate + ".txt");
        BigDecimal totalSales = new BigDecimal(0);

        //Loop through items in inventory to tabulate amount sold
        for(Item item: this.vendingInventory.getItems()){
            //Append each item to SalesReport document with amount sold
            try(PrintWriter dataOutput = new PrintWriter(new FileOutputStream(salesReport, true))){
                //Maths
                int amountSold = Math.abs(item.getQuantity() - 5);
                //Temporary BigDecimal (BD immutable) tabulating machine earnings
                BigDecimal result = totalSales.add(item.getPrice().multiply(BigDecimal.valueOf(amountSold)));
                totalSales = result;
                //String appended to SalesReport
                dataOutput.printf("%s|%d\n", item.getName(), amountSold);
            }catch (FileNotFoundException e){
                System.out.println("File not found");
            }
        }
        //Append machine earning to bottom of SalesReport
        try(PrintWriter dataOutput = new PrintWriter(new FileOutputStream(salesReport, true))){
            dataOutput.println();
            dataOutput.println("**Total Sales** $" + totalSales);
        }catch(FileNotFoundException e){
            System.out.println("File not found");
        }
    }
}
