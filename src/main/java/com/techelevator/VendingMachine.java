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
    public void generateSalesReceipt(){
        SimpleDateFormat formatter = new SimpleDateFormat("dd_MM_yyyy__hh_mmaa");
        String stringSalesDate = formatter.format(new Date());
        File salesReport = new File("SalesReport" + stringSalesDate + ".txt");
        BigDecimal totalSales = new BigDecimal(0);


        for(Item item: this.vendingInventory.getItems()){
            try(PrintWriter dataOutput = new PrintWriter(new FileOutputStream(salesReport, true))){
                int amountSold = Math.abs(item.getQuantity() - 5);
                BigDecimal result = totalSales.add(item.getPrice().multiply(BigDecimal.valueOf(amountSold)));
                totalSales = result;
                dataOutput.printf("%s|%d\n", item.getName(), amountSold);
            }catch (FileNotFoundException e){
                System.out.println("File not found");
            }
        }
        try(PrintWriter dataOutput = new PrintWriter(new FileOutputStream(salesReport, true))){
            dataOutput.println();
            dataOutput.println("**Total Sales** $" + totalSales);
        }catch(FileNotFoundException e){
            System.out.println("File not found");
        }
    }
}
